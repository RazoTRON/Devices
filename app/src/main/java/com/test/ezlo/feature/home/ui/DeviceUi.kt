package com.test.ezlo.feature.home.ui

import androidx.annotation.DrawableRes
import com.test.ezlo.domain.model.Device

data class DeviceUi(
    val title: String,
    val pKDevice: Int,
    @DrawableRes val image: Int
)

fun Device.toUiModel() = DeviceUi(title, pKDevice, platform.image)