package com.test.company.domain.usecase

import android.util.Log
import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.common.AppResult
import com.test.company.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext


class ReloadDevicesUseCase(
    private val deviceRepository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(): AppResult<Unit?> {
        return withContext(dispatcher.IO) {
            try {
                deviceRepository.clear()
                deviceRepository.load()

                AppResult.Success(null)
            } catch (e: Exception) {
                Log.d(this.javaClass.canonicalName, e.localizedMessage ?: e.stackTrace.toString())

                AppResult.Error(e)
            }
        }
    }
}