package com.test.company.data.network

import com.test.company.data.network.model.DeviceResponse
import retrofit2.http.GET

interface DeviceApi {

    @GET("/v1/ab857ef3-73e9-45fa-9508-574973823adc")
    suspend fun get(): DeviceResponse
}