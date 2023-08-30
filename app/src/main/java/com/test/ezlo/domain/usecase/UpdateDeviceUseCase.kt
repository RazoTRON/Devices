package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.model.UpdateDeviceParam
import com.test.ezlo.domain.repository.DeviceRepository
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