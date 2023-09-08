package com.test.company.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.company.domain.common.AppResult
import com.test.company.domain.model.User
import com.test.company.domain.usecase.GetDevicesUseCase
import com.test.company.domain.usecase.GetUserUseCase
import com.test.company.domain.usecase.LoadDevicesUseCase
import com.test.company.domain.usecase.ReloadDevicesUseCase
import com.test.company.feature.home.ui.model.DeviceUi
import com.test.company.feature.home.ui.model.toUiModel
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
    private val reloadDevicesUseCase: ReloadDevicesUseCase,
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

    fun reloadDevices() {
        viewModelScope.launch {
            val result = reloadDevicesUseCase.execute()

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