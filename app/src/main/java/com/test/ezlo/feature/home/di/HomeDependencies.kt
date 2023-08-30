package com.test.ezlo.feature.home.di

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import com.test.ezlo.domain.usecase.DeleteDeviceUseCase
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase
import com.test.ezlo.feature.details_api.DetailsFeatureApi

interface HomeDependencies {
    val userRepository: UserRepository
    val deviceRepository: DeviceRepository
    val appCoroutineDispatcher: AppCoroutineDispatcher

    val detailsFeatureApi: DetailsFeatureApi
}