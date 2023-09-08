package com.test.company.di

import com.test.company.feature.details.api.DetailsFeatureApiImpl
import com.test.company.feature.details_api.DetailsFeatureApi
import com.test.company.feature.home.api.HomeFeatureApiImpl
import com.test.company.feature.home_api.HomeFeatureApi
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

    @Provides
    fun provideHomeFeatureApi(): HomeFeatureApi {
        return HomeFeatureApiImpl()
    }

    @Provides
    fun provideDetailsFeatureApi(): DetailsFeatureApi {
        return DetailsFeatureApiImpl()
    }
}