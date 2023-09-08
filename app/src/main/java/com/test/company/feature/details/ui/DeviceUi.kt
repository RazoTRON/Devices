package com.test.company.feature.details.ui

import androidx.annotation.DrawableRes
import com.test.company.domain.model.Device

data class DeviceUi(
    val title: String,
    val pKDevice: Int,
    val firmware: String,
    val macAddress: String,
    val model: String,
    @DrawableRes val image: Int
)

fun Device.toUiModel() = DeviceUi(title, pKDevice, firmware, macAddress, platform.key, platform.image)