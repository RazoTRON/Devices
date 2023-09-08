package com.test.company.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.google.gson.Gson
import com.test.company.BuildConfig
import com.test.company.data.common.model.BaseUrl
import com.test.company.data.network.DeviceApi
import com.test.company.data.repository.DeviceRepositoryImpl
import com.test.company.data.repository.UserRepositoryImpl
import com.test.company.data.storage.db.DeviceDao
import com.test.company.data.storage.db.DeviceDatabase
import com.test.company.data.storage.prefs.DeviceLoadPrefs
import com.test.company.domain.repository.DeviceRepository
import com.test.company.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

val Context.deviceLoadPrefs: DataStore<Preferences> by preferencesDataStore(name = "deviceLoadPreferences")

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideBaseUrl(): BaseUrl {
        return BaseUrl(BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, baseUrl: BaseUrl): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl.url)
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
    fun provideDeviceRepository(
        deviceApi: DeviceApi,
        deviceDao: DeviceDao,
        deviceLoadPrefs: DeviceLoadPrefs,
    ): DeviceRepository {
        return DeviceRepositoryImpl(deviceApi, deviceDao, deviceLoadPrefs)
    }

    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl()
    }

    @Provides
    fun provideDeviceLoadPrefs(context: Context): DeviceLoadPrefs {
        return DeviceLoadPrefs(context.deviceLoadPrefs)
    }
}