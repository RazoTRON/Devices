package com.test.company.data.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DeviceEntity::class],
    version = 2
)
abstract class DeviceDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
}