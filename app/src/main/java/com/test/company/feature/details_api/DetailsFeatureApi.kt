package com.test.company.feature.details_api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface DetailsFeatureApi {
    fun register(navGraphBuilder: NavGraphBuilder, navController: NavController)
    fun detailsRoute(pkDevice: Int): String
    fun editRoute(pkDevice: Int): String
}