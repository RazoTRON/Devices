package com.test.ezlo.feature.details.di

import com.test.ezlo.domain.usecase.GetDeviceByPkUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.SaveDeviceUseCase

interface DetailsDependencies {
    val getDeviceByPkUseCase: GetDeviceByPkUseCase
    val getUserUseCase: GetUserUseCase
    val saveDeviceUseCase: SaveDeviceUseCase
}