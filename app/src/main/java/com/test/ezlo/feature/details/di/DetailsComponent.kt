package com.test.ezlo.feature.details.di

import com.test.ezlo.feature.details.ui.DetailsViewModel
import dagger.Component

@Component(modules = [DetailsModule::class], dependencies = [DetailsDependencies::class])
@DetailsScope
internal interface DetailsComponent {

    @Component.Builder
    interface Builder {

        fun provideDependencies(di: DetailsDependencies): Builder
        fun build(): DetailsComponent
    }

    val viewModelAssistedFactory: DetailsViewModel.Factory
}