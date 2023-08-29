package com.test.ezlo.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.test.ezlo.data.network.DeviceApi
import com.test.ezlo.data.repository.DeviceRepositoryImpl
import com.test.ezlo.data.repository.UserRepositoryImpl
import com.test.ezlo.data.storage.DeviceDao
import com.test.ezlo.data.storage.DeviceDatabase
import com.test.ezlo.domain.repository.DeviceRepository
import com.test.ezlo.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://veramobile.mios.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Provides
    @Singleton
    fun provideDeviceApi(retrofit: Retrofit): DeviceApi {
        return retrofit.create(DeviceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): DeviceDatabase {
        return Room.databaseBuilder(context, DeviceDatabase::class.java, "device_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDeviceDao(deviceDatabase: DeviceDatabase): DeviceDao {
        return deviceDatabase.deviceDao()
    }

    @Provides
    fun provideDeviceRepository(deviceApi: DeviceApi, deviceDao: DeviceDao): DeviceRepository {
        return DeviceRepositoryImpl(deviceApi, deviceDao)
    }

    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl()
    }
}