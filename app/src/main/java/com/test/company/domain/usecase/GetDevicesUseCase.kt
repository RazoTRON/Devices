package com.test.company.domain.usecase

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.model.Device
import com.test.company.domain.repository.DeviceRepository
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