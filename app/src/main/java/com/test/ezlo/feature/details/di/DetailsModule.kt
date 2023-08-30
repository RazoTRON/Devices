package com.test.ezlo.feature.details.di

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import com.test.ezlo.domain.usecase.GetDeviceByPkUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.SaveDeviceUseCase
import com.test.ezlo.domain.usecase.UpdateDeviceUseCase
import dagger.Module
import dagger.Provides

@Module
class DetailsModule {

    @Provides
    fun provideGetUserUseCase(
        repository: UserRepository,
        dispatcher: AppCoroutineDispatcher,
    ): GetUserUseCase {
        return GetUserUseCase(repository, dispatcher)
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
}