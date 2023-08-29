package com.test.ezlo.di

import com.test.ezlo.feature.details.api.DetailsFeatureApiImpl
import com.test.ezlo.feature.details_api.DetailsFeatureApi
import com.test.ezlo.feature.home.api.HomeFeatureApiImpl
import com.test.ezlo.feature.home_api.HomeFeatureApi
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