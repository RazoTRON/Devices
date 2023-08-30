package com.test.ezlo.feature.details.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.test.ezlo.core_ui.util.injectViewModel
import com.test.ezlo.feature.details.di.DaggerDetailsComponent
import com.test.ezlo.feature.details.ui.DetailsScreen
import com.test.ezlo.feature.details_api.DetailsFeatureApi
import com.test.ezlo.feature.details.di.DetailsDiProvider
import com.test.ezlo.feature.details.ui.DetailsScreenMode

class DetailsFeatureApiImpl : DetailsFeatureApi {

    private val mainRoute = "details"

    private val screenModeKey = "screen_mode_key"
    private val pkDeviceKey = "pkDevice_key"
    override fun detailsRoute(pkDevice: Int) = "$mainRoute/${pkDevice}/${DetailsScreenMode.VIEW.name}"
    override fun editRoute(pkDevice: Int) = "$mainRoute/${pkDevice}/${DetailsScreenMode.EDIT.name}"

    override fun register(navGraphBuilder: NavGraphBuilder, navController: NavController) {

        val di = DaggerDetailsComponent.builder()
            .provideDependencies(DetailsDiProvider.di)
            .build()

        navGraphBuilder.composable(
            route = "$mainRoute/{$pkDeviceKey}/{$screenModeKey}",
            arguments = listOf(navArgument(pkDeviceKey) { type = NavType.IntType })
        ) { navBackStackEntry ->

            val arguments = requireNotNull(navBackStackEntry.arguments)
            val pkDevice = requireNotNull(arguments.getInt(pkDeviceKey))
            val screenMode = requireNotNull(arguments.getString(screenModeKey))

            DetailsScreen(
                vm = injectViewModel { di.viewModelAssistedFactory.create(screenMode, pkDevice) },
                onMoveBack = { navController.popBackStack() }
            )
        }
    }
}