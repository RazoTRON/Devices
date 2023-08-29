package com.test.ezlo.domain.repository

import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.model.UpdateDeviceParam
import kotlinx.coroutines.flow.Flow

interface DeviceRepository {
    suspend fun load()
    fun delete(device: Device)
    fun getFlow(): Flow<List<Device>>
    fun getByPk(pKDevice: Int): Device?
    fun clear()
    fun update(updateDeviceParam: UpdateDeviceParam)
}