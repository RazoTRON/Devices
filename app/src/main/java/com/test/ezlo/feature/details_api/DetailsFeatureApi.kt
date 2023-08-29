package com.test.ezlo.feature.details_api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface DetailsFeatureApi {
    fun register(navGraphBuilder: NavGraphBuilder, navController: NavController)
    val mainRoute: String
}