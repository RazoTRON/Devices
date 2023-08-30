package com.test.ezlo.di

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import com.test.ezlo.domain.usecase.DeleteDeviceUseCase
import com.test.ezlo.domain.usecase.GetDeviceByPkUseCase
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase
import com.test.ezlo.domain.usecase.SaveDeviceUseCase
import com.test.ezlo.domain.usecase.UpdateDeviceUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideDispatchers(): AppCoroutineDispatcher {
        return AppCoroutineDispatcher()
    }
}