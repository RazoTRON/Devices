package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GetDevicesUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(): Flow<List<Device>> {
        return withContext(dispatcher.IO) {
            repository.getFlow()
        }
    }
}