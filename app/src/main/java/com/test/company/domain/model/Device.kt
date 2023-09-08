package com.test.company.domain.model

data class Device(
    val title: String,
    val pKDevice: Int,
    val firmware: String,
    val internalIP: String,
    val lastAliveReported: String,
    val macAddress: String,
    val pKAccount: Int?,
    val pKDeviceSubType: Int,
    val pKDeviceType: Int,
    val platform: Platform,
    val serverAccount: String,
    val serverDevice: String,
    val serverEvent: String
)