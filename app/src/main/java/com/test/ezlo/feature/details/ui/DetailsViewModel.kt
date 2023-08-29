package com.test.ezlo.feature.details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.test.ezlo.data.repository.DeviceRepositoryImpl
import com.test.ezlo.data.network.DeviceApi
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsViewModel @AssistedInject constructor(
    private val getDevicesUseCase: GetDevicesUseCase
) : ViewModel() {

    fun fetch() {
        viewModelScope.launch {
            val res = getDevicesUseCase.execute()

            res.collect {
                it.forEach { println(it.macAddress) }
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): DetailsViewModel
    }
}