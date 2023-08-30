package com.test.ezlo.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.ezlo.domain.common.AppResult
import com.test.ezlo.domain.model.User
import com.test.ezlo.domain.usecase.DeleteDeviceUseCase
import com.test.ezlo.domain.usecase.GetDevicesUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.LoadDevicesUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HomeScreenState(
    val devices: List<DeviceUi> = listOf(),
    val user: User = User(id = 0, firstName = "", lastName = "", photoUrl = "")
)

class HomeViewModel @AssistedInject constructor(
    private val getDevicesUseCase: GetDevicesUseCase,
    private val loadDevicesUseCase: LoadDevicesUseCase,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    init {
        loadUser()
        loadDevices()
        fetchDevices()
    }

    fun loadDevices() {
        viewModelScope.launch {
            val result = loadDevicesUseCase.execute()

            when (result) {
                is AppResult.Success -> { /* DO NOTHING */ }
                is AppResult.Error -> { /* SHOW ERROR MESSAGE */ }
            }
        }
    }

    private fun loadUser() {
        viewModelScope.launch {
            val result = getUserUseCase.execute()

            _state.emit(state.value.copy(user = result))
        }
    }

    private fun fetchDevices() {
        viewModelScope.launch {
            getDevicesUseCase.execute().collect { _list ->
                val list = _list.map { device -> device.toUiModel() }

                list.forEach { device ->
                    println(device.pKDevice)
                }

                _state.emit(state.value.copy(devices = list))
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): HomeViewModel
    }
}