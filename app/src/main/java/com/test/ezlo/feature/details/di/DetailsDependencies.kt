package com.test.ezlo.feature.details.di

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import com.test.ezlo.domain.usecase.GetDeviceByPkUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.SaveDeviceUseCase

interface DetailsDependencies {
    val userRepository: UserRepository
    val deviceRepository: DeviceRepository
    val appCoroutineDispatcher: AppCoroutineDispatcher
}