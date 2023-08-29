package com.test.ezlo.feature.home.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun HomeScreen(vm: HomeViewModel) {

    LaunchedEffect(key1 = Unit) {
        vm.load()
    }

    Button(onClick = { vm.load() }) {
        Text("Test")
    }
}