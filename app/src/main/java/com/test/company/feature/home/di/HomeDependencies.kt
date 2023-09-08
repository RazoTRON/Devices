package com.test.company.feature.home.di

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.repository.DeviceRepository
import com.test.company.domain.repository.UserRepository
import com.test.company.feature.details_api.DetailsFeatureApi

interface HomeDependencies {
    val userRepository: UserRepository
    val deviceRepository: DeviceRepository
    val appCoroutineDispatcher: AppCoroutineDispatcher

    val detailsFeatureApi: DetailsFeatureApi
}