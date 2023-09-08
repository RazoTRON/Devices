package com.test.company.domain.usecase

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.repository.DeviceRepository
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