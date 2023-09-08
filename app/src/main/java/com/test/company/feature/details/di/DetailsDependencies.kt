package com.test.company.feature.details.di

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.repository.DeviceRepository
import com.test.company.domain.repository.UserRepository

interface DetailsDependencies {
    val userRepository: UserRepository
    val deviceRepository: DeviceRepository
    val appCoroutineDispatcher: AppCoroutineDispatcher
}