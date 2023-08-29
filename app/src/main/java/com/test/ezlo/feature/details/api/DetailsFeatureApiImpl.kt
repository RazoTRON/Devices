package com.test.ezlo.feature.details.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.test.ezlo.core_ui.util.injectViewModel
import com.test.ezlo.feature.details.di.DaggerDetailsComponent
import com.test.ezlo.feature.details.ui.DetailsScreen
import com.test.ezlo.feature.details_api.DetailsFeatureApi
import com.test.ezlo.feature.details.di.DetailsDiProvider

class DetailsFeatureApiImpl : DetailsFeatureApi {

    override val mainRoute = "details"

    override fun register(navGraphBuilder: NavGraphBuilder, navController: NavController) {

        val di = DaggerDetailsComponent.builder()
            .provideDependencies(DetailsDiProvider.di)
            .build()

        navGraphBuilder.composable(mainRoute) {
            DetailsScreen(vm = injectViewModel { di.viewModelAssistedFactory.create() })
        }
    }
}