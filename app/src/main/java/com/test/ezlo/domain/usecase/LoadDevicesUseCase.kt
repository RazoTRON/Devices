package com.test.ezlo.domain.usecase

import android.util.Log
import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.common.AppResult
import com.test.ezlo.domain.repository.DeviceRepository
import kotlinx.coroutines.withContext

class LoadDevicesUseCase(
    private val repository: DeviceRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(): AppResult<Unit?> {
        return withContext(dispatcher.IO) {
            try {
                repository.clear()
                repository.load()

                AppResult.Success(null)
            } catch (e: Exception) {
                Log.d(this.javaClass.canonicalName, e.localizedMessage ?: e.stackTrace.toString())

                AppResult.Error(e)
            }
        }
    }
}