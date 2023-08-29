package com.test.ezlo.data.network.model

import com.google.gson.annotations.SerializedName
import com.test.ezlo.data.storage.DeviceParam
import com.test.ezlo.domain.model.Device as DeviceDomain

data class DeviceDto(
    @SerializedName("Firmware")
    val firmware: String,
    @SerializedName("InternalIP")
    val internalIP: String,
    @SerializedName("LastAliveReported")
    val lastAliveReported: String,
    @SerializedName("MacAddress")
    val macAddress: String,
    @SerializedName("PK_Account")
    val pKAccount: Int?,
    @SerializedName("PK_Device")
    val pKDevice: Int,
    @SerializedName("PK_DeviceSubType")
    val pKDeviceSubType: Int,
    @SerializedName("PK_DeviceType")
    val pKDeviceType: Int,
    @SerializedName("Platform")
    val platform: String,
    @SerializedName("Server_Account")
    val serverAccount: String,
    @SerializedName("Server_Device")
    val serverDevice: String,
    @SerializedName("Server_Event")
    val serverEvent: String,
)

fun DeviceDto.toDeviceParam(title: String) = DeviceParam(
    pKDevice = pKDevice,
    title = title,
    firmware = firmware,
    internalIP = internalIP,
    lastAliveReported = lastAliveReported,
    macAddress = macAddress,
    pKAccount = pKAccount,
    pKDeviceSubType = pKDeviceSubType,
    pKDeviceType = pKDeviceType,
    platform = platform,
    serverAccount = serverAccount,
    serverDevice = serverDevice,
    serverEvent = serverEvent
)