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
    fun provideUpdateDeviceUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): UpdateDeviceUseCase {
        return UpdateDeviceUseCase(repository, dispatcher)
    }

    @Provides
    fun provideGetDeviceByPkUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): GetDeviceByPkUseCase {
        return GetDeviceByPkUseCase(repository, dispatcher)
    }

    @Provides
    fun provideSaveDeviceUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): SaveDeviceUseCase {
        return SaveDeviceUseCase(repository, dispatcher)
    }

    @Provides
    fun provideDeleteDeviceUseCase(
        repository: DeviceRepository,
        dispatcher: AppCoroutineDispatcher,
    ): DeleteDeviceUseCase {
        return DeleteDeviceUseCase(repository, dispatcher)
    }
}