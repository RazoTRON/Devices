package com.test.ezlo.data.network.model

import com.google.gson.annotations.SerializedName

data class DeviceResponse(
    @SerializedName("Devices")
    val deviceDtos: List<DeviceDto>
)