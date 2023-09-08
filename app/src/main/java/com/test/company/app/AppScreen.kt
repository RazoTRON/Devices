package com.test.company.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    Scaffold {
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }
}