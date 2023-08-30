package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.model.UpdateDeviceParam
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.Flow
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