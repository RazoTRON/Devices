package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext

class LoadDevicesUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute() {
        return withContext(dispatcher.IO) {
            repository.clear()
            repository.load()
        }
    }
}