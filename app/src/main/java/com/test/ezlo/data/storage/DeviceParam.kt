package com.test.ezlo.data.storage

data class DeviceParam(
    val pKDevice: Int,
    val title: String,
    val firmware: String,
    val internalIP: String,
    val lastAliveReported: String,
    val macAddress: String,
    val pKAccount: Int?,
    val pKDeviceSubType: Int,
    val pKDeviceType: Int,
    val platform: String,
    val serverAccount: String,
    val serverDevice: String,
    val serverEvent: String
)