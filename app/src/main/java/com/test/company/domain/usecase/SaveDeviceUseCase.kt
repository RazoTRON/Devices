package com.test.company.domain.usecase

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.model.UpdateDeviceParam
import com.test.company.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext

class SaveDeviceUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(updateParam: UpdateDeviceParam): Unit {
        return withContext(dispatcher.IO) {
            repository.update(updateParam)
        }
    }
}