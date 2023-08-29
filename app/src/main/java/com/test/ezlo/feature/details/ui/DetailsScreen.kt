package com.test.ezlo.feature.details.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun DetailsScreen(vm: DetailsViewModel) {

    LaunchedEffect(Unit) {
        vm.fetch()
    }

    Text("Test")
}