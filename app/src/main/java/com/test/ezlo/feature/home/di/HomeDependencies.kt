package com.test.ezlo.feature.home.di

import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase

interface HomeDependencies {
    val getDevicesUseCase: GetDevicesUseCase
    val loadDevicesUseCase: LoadDevicesUseCase
}