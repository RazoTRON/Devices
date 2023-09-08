package com.test.company.feature.home.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.test.company.core_ui.util.injectViewModel
import com.test.company.feature.home.di.DaggerHomeComponent
import com.test.company.feature.home.di.HomeDiProvider
import com.test.company.feature.home.ui.delete_dialog.DeleteDialogContent
import com.test.company.feature.home.ui.HomeScreen
import com.test.company.feature.home_api.HomeFeatureApi

class HomeFeatureApiImpl : HomeFeatureApi {

    override val mainRoute = "home_graph"
    private val homeRoute = "home"
    private val deleteRoute = "delete"

    private val pkDeviceKey = "pkDevice_key"
    private fun deleteDialogRoute(pkDevice: Int) = "$deleteRoute/${pkDevice}"

    override fun register(navGraphBuilder: NavGraphBuilder, navController: NavController) {

        val di = DaggerHomeComponent.builder()
            .provideDependencies(HomeDiProvider.di)
            .build()

        navGraphBuilder.navigation(startDestination = homeRoute, route = mainRoute) {

            composable(homeRoute) {
                HomeScreen(
                    vm = injectViewModel { di.homeViewModelAssistedFactory.create() },
                    onEditClick = {
                        navController.navigate(di.detailsFeatureApi.editRoute(it))
                    },
                    onItemClick = {
                        navController.navigate(di.detailsFeatureApi.detailsRoute(it))
                    },
                    onItemLongClick = {
                        navController.navigate(deleteDialogRoute(it))
                    }
                )
            }

            dialog(
                "$deleteRoute/{$pkDeviceKey}",
                arguments = listOf(navArgument(pkDeviceKey) { type = NavType.IntType })
            ) { navBackStackEntry ->

                val arguments = requireNotNull(navBackStackEntry.arguments)
                val pkDevice = requireNotNull(arguments.getInt(pkDeviceKey))

                DeleteDialogContent(
                    viewModel = injectViewModel { di.deleteViewModelAssistedFactory.create(pkDevice) },
                    moveBack = { navController.popBackStack() }
                )
            }

            di.detailsFeatureApi.register(navGraphBuilder, navController)
        }
    }
}