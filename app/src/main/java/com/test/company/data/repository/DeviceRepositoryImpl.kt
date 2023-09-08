package com.test.company.data.repository

import com.test.company.data.network.DeviceApi
import com.test.company.data.network.model.toDeviceParam
import com.test.company.data.storage.db.DeviceDao
import com.test.company.data.storage.db.toDomainModel
import com.test.company.data.storage.prefs.DeviceLoadPrefs
import com.test.company.domain.model.Device
import com.test.company.domain.model.UpdateDeviceParam
import com.test.company.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DeviceRepositoryImpl(
    private val deviceApi: DeviceApi,
    private val deviceDao: DeviceDao,
    private val deviceLoadPrefs: DeviceLoadPrefs
) : DeviceRepository {

    override suspend fun load() {
        val response = deviceApi.get()

        val deviceList = response.deviceDtos.mapIndexed { i, device ->
            device.toDeviceParam("Home number $i")
        }

        deviceDao.insert(*deviceList.toTypedArray())

        deviceLoadPrefs.setLoadStatus(isLoaded = true)
    }

    override suspend fun isLoaded(): Boolean {
        return deviceLoadPrefs.getLoadStatus()
    }

    override fun getFlow(): Flow<List<Device>> {
        return deviceDao.getFlowList().map { list ->
            list.map { entity ->
                entity.toDomainModel()
            }
        }
    }

    override fun getByPk(pKDevice: Int): Device? {
        return deviceDao.findByDevicePk(pKDevice)?.toDomainModel()
    }

    override fun update(updateDeviceParam: UpdateDeviceParam) {
        val device = deviceDao.findByDevicePk(updateDeviceParam.pKDevice)
            ?: throw Exception("Device not found.")

        deviceDao.update(device.copy(title = updateDeviceParam.title))
    }

    override fun delete(pkDevice: Int) {
        deviceDao.delete(pkDevice)
    }

    override fun clear() {
        deviceDao.clear()
    }
}