package com.test.ezlo.feature.home_api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface HomeFeatureApi {
    fun register(navGraphBuilder: NavGraphBuilder, navController: NavController)
    val mainRoute: String
}