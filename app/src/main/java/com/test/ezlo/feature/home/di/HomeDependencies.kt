package com.test.ezlo.feature.home.di

import com.test.ezlo.domain.usecase.DeleteDeviceUseCase
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase
import com.test.ezlo.feature.details_api.DetailsFeatureApi

interface HomeDependencies {
    val getDevicesUseCase: GetDevicesUseCase
    val loadDevicesUseCase: LoadDevicesUseCase
    val getUserUseCase: GetUserUseCase
    val deleteDeviceUseCase: DeleteDeviceUseCase

    val detailsFeatureApi: DetailsFeatureApi
}