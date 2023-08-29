package com.test.ezlo.feature.home.di

import com.test.ezlo.feature.details.di.DetailsScope
import com.test.ezlo.feature.home.ui.HomeViewModel
import dagger.Component

@Component(modules = [HomeModule::class], dependencies = [HomeDependencies::class])
@DetailsScope
internal interface HomeComponent {

    @Component.Builder
    interface Builder {

        fun provideDependencies(di: HomeDependencies): Builder
        fun build(): HomeComponent
    }

    val viewModelAssistedFactory: HomeViewModel.Factory
}