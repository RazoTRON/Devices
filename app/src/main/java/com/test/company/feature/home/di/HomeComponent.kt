package com.test.company.feature.home.di

import com.test.company.feature.details.di.DetailsScope
import com.test.company.feature.details_api.DetailsFeatureApi
import com.test.company.feature.home.ui.delete_dialog.DeleteDialogViewModel
import com.test.company.feature.home.ui.HomeViewModel
import dagger.Component

@Component(modules = [HomeModule::class], dependencies = [HomeDependencies::class])
@DetailsScope
internal interface HomeComponent {

    @Component.Builder
    interface Builder {

        fun provideDependencies(di: HomeDependencies): Builder
        fun build(): HomeComponent
    }

    val homeViewModelAssistedFactory: HomeViewModel.Factory
    val deleteViewModelAssistedFactory: DeleteDialogViewModel.Factory
    val detailsFeatureApi: DetailsFeatureApi
}