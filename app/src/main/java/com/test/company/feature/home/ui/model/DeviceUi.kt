package com.test.company.feature.home.ui.model

import androidx.annotation.DrawableRes
import com.test.company.domain.model.Device

data class DeviceUi(
    val title: String,
    val pKDevice: Int,
    @DrawableRes val image: Int
)

fun Device.toUiModel() = DeviceUi(title, pKDevice, platform.image)