package com.test.ezlo.feature.home.ui

import androidx.annotation.StringRes
import com.test.ezlo.domain.model.Device

data class DeviceUi(
    val title: String,
    val pKDevice: Int,
    @StringRes val image: Int
)

fun Device.toUiModel() = DeviceUi(title, pKDevice, platform.image)