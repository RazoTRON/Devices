package com.test.company.domain.repository

import com.test.company.domain.model.Device
import com.test.company.domain.model.UpdateDeviceParam
import kotlinx.coroutines.flow.Flow

interface DeviceRepository {
    suspend fun load()
    fun delete(pkDevice: Int)
    fun getFlow(): Flow<List<Device>>
    fun getByPk(pKDevice: Int): Device?
    fun clear()
    fun update(updateDeviceParam: UpdateDeviceParam)
    suspend fun isLoaded(): Boolean
}