package com.test.ezlo.data.network

import com.test.ezlo.data.network.model.DeviceResponse
import retrofit2.http.GET

interface DeviceApi {

    @GET("/test_android/items.test")
    suspend fun get(): DeviceResponse
}