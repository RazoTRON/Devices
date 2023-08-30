package com.test.ezlo.feature.home.di

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import com.test.ezlo.domain.usecase.DeleteDeviceUseCase
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideGetDevicesUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): GetDevicesUseCase {
        return GetDevicesUseCase(repository, dispatcher)
    }

    @Provides
    fun provideGetUserUseCase(
        repository: UserRepository,
        dispatcher: AppCoroutineDispatcher,
    ): GetUserUseCase {
        return GetUserUseCase(repository, dispatcher)
    }

    @Provides
    fun provideLoadDevicesUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): LoadDevicesUseCase {
        return LoadDevicesUseCase(repository, dispatcher)
    }

    @Provides
    fun provideDeleteDeviceUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): DeleteDeviceUseCase {
        return DeleteDeviceUseCase(repository, dispatcher)
    }
}