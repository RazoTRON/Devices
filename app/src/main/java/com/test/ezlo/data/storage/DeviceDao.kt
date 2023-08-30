package com.test.ezlo.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.test.ezlo.data.network.model.DeviceDto
import com.test.ezlo.domain.model.Device
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {

    @Insert(entity = DeviceEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg devices: DeviceParam)

    @Query("DELETE FROM ${DeviceEntity.TABLE_NAME} WHERE ${DeviceEntity.PK_DEVICE} = :pkDevice")
    fun delete(pkDevice: Int)

    @Query("DELETE FROM ${DeviceEntity.TABLE_NAME}")
    fun clear()

    @Query("SELECT * FROM ${DeviceEntity.TABLE_NAME} WHERE ${DeviceEntity.PK_DEVICE} = :pkDevice LIMIT 1")
    fun findByDevicePk(pkDevice: Int): DeviceEntity?

    @Query("SELECT * FROM ${DeviceEntity.TABLE_NAME} ORDER BY ${DeviceEntity.PK_DEVICE} ASC")
    fun getFlowList(): Flow<List<DeviceEntity>>

    @Update(entity = DeviceEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun update(device: DeviceEntity)
}