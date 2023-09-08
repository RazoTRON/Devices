package com.test.company.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.test.company.di.AppComponent
import com.test.company.di.AppDiProvider

@Composable
internal fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    di: AppComponent = AppDiProvider.di,
) {

    NavHost(
        navController = navController,
        startDestination = di.homeFeatureApi.mainRoute,
        modifier = modifier
    ) {
        di.homeFeatureApi.register(this, navController)
    }
}