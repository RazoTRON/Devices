package com.test.ezlo.feature.home.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.test.ezlo.core_ui.util.injectViewModel
import com.test.ezlo.feature.home.di.DaggerHomeComponent
import com.test.ezlo.feature.home.di.HomeDiProvider
import com.test.ezlo.feature.home.ui.HomeScreen
import com.test.ezlo.feature.home_api.HomeFeatureApi

class HomeFeatureApiImpl : HomeFeatureApi {

    override val mainRoute = "home"

    override fun register(navGraphBuilder: NavGraphBuilder, navController: NavController) {

        val di = DaggerHomeComponent.builder()
            .provideDependencies(HomeDiProvider.di)
            .build()

        navGraphBuilder.composable(mainRoute) {
            HomeScreen(vm = injectViewModel { di.viewModelAssistedFactory.create() })
        }
    }
}