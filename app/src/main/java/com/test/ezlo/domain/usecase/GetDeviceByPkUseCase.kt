package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext

class GetDeviceByPkUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(pK: Int): Device? {
        return withContext(dispatcher.IO) {
            repository.getByPk(pK)
        }
    }
}