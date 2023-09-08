package com.test.company.domain.usecase

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.model.UpdateDeviceParam
import com.test.company.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext

class UpdateDeviceUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(updateDeviceParam: UpdateDeviceParam) {
        withContext(dispatcher.IO) {
            repository.update(updateDeviceParam)
        }
    }
}