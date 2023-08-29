package com.test.ezlo.data.repository

import com.test.ezlo.data.network.DeviceApi
import com.test.ezlo.data.network.model.toDeviceParam
import com.test.ezlo.data.storage.DeviceDao
import com.test.ezlo.data.storage.toDomainModel
import com.test.ezlo.data.storage.toEntity
import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.model.UpdateDeviceParam
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DeviceRepositoryImpl(
    private val deviceApi: DeviceApi,
    private val deviceDao: DeviceDao,
) : DeviceRepository {

    override suspend fun load() {
        val response = deviceApi.get()

        val deviceList = response.deviceDtos.mapIndexed { i, device ->
            device.toDeviceParam("Home number $i")
        }

        deviceDao.insert(*deviceList.toTypedArray())
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

    override fun delete(device: Device) {
        deviceDao.delete(device.toEntity())
    }

    override fun clear() {
        deviceDao.clear()
    }
}