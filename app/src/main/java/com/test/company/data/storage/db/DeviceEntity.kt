package com.test.company.data.storage.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.company.data.storage.db.DeviceEntity.Companion.TABLE_NAME
import com.test.company.domain.model.Device
import com.test.company.domain.model.Platform

@Entity(TABLE_NAME)
data class DeviceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(PK_DEVICE)
    val pKDevice: Int,
    @ColumnInfo(TITLE)
    val title: String,
    @ColumnInfo(FIRMWARE)
    val firmware: String,
    @ColumnInfo(INTERNAL_IP)
    val internalIP: String,
    @ColumnInfo(LAST_ALIVE)
    val lastAliveReported: String,
    @ColumnInfo(MAC)
    val macAddress: String,
    @ColumnInfo(PK_ACCOUNT)
    val pKAccount: Int?,
    @ColumnInfo(PK_DEVICE_SUBTYPE)
    val pKDeviceSubType: Int,
    @ColumnInfo(PK_DEVICE_TYPE)
    val pKDeviceType: Int,
    @ColumnInfo(PLATFORM)
    val platform: String,
    @ColumnInfo(SERVER_ACCOUNT)
    val serverAccount: String,
    @ColumnInfo(SERVER_DEVICE)
    val serverDevice: String,
    @ColumnInfo(SERVER_EVENT)
    val serverEvent: String
) {
    companion object {
        const val TABLE_NAME = "device_table"
        const val TITLE = "title"
        const val FIRMWARE = "firmware"
        const val INTERNAL_IP = "internalIP"
        const val LAST_ALIVE = "lastAliveReported"
        const val MAC = "macAddress"
        const val PK_ACCOUNT = "pKAccount"
        const val PK_DEVICE = "pKDevice"
        const val PK_DEVICE_SUBTYPE = "pKDeviceSubType"
        const val PK_DEVICE_TYPE = "pKDeviceType"
        const val PLATFORM = "platform"
        const val SERVER_ACCOUNT = "serverAccount"
        const val SERVER_DEVICE = "serverDevice"
        const val SERVER_EVENT = "serverEvent"
    }
}

fun DeviceEntity.toDomainModel(): Device {
    return Device(
        title = title,
        firmware = firmware,
        internalIP = internalIP,
        lastAliveReported = lastAliveReported,
        macAddress = macAddress,
        pKAccount = pKAccount,
        pKDevice = pKDevice,
        pKDeviceSubType = pKDeviceSubType,
        pKDeviceType = pKDeviceType,
        platform = Platform.getByKey(platform),
        serverAccount = serverAccount,
        serverDevice = serverDevice,
        serverEvent = serverEvent
    )
}