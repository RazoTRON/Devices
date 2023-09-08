package com.test.company.domain.usecase

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.model.Device
import com.test.company.domain.repository.DeviceRepository
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