package com.test.company.feature.home.di

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.repository.DeviceRepository
import com.test.company.domain.repository.UserRepository
import com.test.company.domain.usecase.DeleteDeviceUseCase
import com.test.company.domain.usecase.GetDevicesUseCase
import com.test.company.domain.usecase.GetUserUseCase
import com.test.company.domain.usecase.LoadDevicesUseCase
import com.test.company.domain.usecase.ReloadDevicesUseCase
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
    fun provideReloadDevicesUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): ReloadDevicesUseCase {
        return ReloadDevicesUseCase(repository, dispatcher)
    }

    @Provides
    fun provideDeleteDeviceUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): DeleteDeviceUseCase {
        return DeleteDeviceUseCase(repository, dispatcher)
    }
}