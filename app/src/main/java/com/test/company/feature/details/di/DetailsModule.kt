package com.test.company.feature.details.di

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.repository.DeviceRepository
import com.test.company.domain.repository.UserRepository
import com.test.company.domain.usecase.GetDeviceByPkUseCase
import com.test.company.domain.usecase.GetUserUseCase
import com.test.company.domain.usecase.SaveDeviceUseCase
import com.test.company.domain.usecase.UpdateDeviceUseCase
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