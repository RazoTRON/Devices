package com.test.ezlo.feature.details.di

import com.test.ezlo.domain.usecase.GetDevicesUseCase

interface DetailsDependencies {
    val getDevicesUseCase: GetDevicesUseCase
}