package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext

class DeleteDeviceUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(pK: Int) {
        return withContext(dispatcher.IO) {
            repository.delete(pK)
        }
    }
}