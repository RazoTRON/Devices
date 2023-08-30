package com.test.ezlo.di

import android.content.Context
import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import com.test.ezlo.domain.usecase.DeleteDeviceUseCase
import com.test.ezlo.domain.usecase.GetDeviceByPkUseCase
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase
import com.test.ezlo.domain.usecase.SaveDeviceUseCase
import com.test.ezlo.feature.details.di.DetailsDependencies
import com.test.ezlo.feature.details_api.DetailsFeatureApi
import com.test.ezlo.feature.home.di.HomeDependencies
import com.test.ezlo.feature.home_api.HomeFeatureApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class, DomainModule::class, FeatureModule::class])
@Singleton
internal interface AppComponent : HomeDependencies, DetailsDependencies {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun provideContext(context: Context): Builder
        fun build(): AppComponent
    }

    val homeFeatureApi: HomeFeatureApi
    override val detailsFeatureApi: DetailsFeatureApi

    override val deviceRepository: DeviceRepository
    override val userRepository: UserRepository

    override val appCoroutineDispatcher: AppCoroutineDispatcher
}