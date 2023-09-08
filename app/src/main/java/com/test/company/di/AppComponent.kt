package com.test.company.di

import android.content.Context
import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.repository.DeviceRepository
import com.test.company.domain.repository.UserRepository
import com.test.company.feature.details.di.DetailsDependencies
import com.test.company.feature.details_api.DetailsFeatureApi
import com.test.company.feature.home.di.HomeDependencies
import com.test.company.feature.home_api.HomeFeatureApi
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