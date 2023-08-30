package com.test.ezlo.feature.details.ui

import androidx.annotation.DrawableRes
import com.test.ezlo.domain.model.Device
import com.test.ezlo.domain.model.Platform

data class DeviceUi(
    val title: String,
    val pKDevice: Int,
    val firmware: String,
    val macAddress: String,
    val model: String,
    @DrawableRes val image: Int
)

fun Device.toUiModel() = DeviceUi(title, pKDevice, firmware, macAddress, platform.key, platform.image)