package com.test.ezlo.feature.details.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.ezlo.domain.model.UpdateDeviceParam
import com.test.ezlo.domain.model.User
import com.test.ezlo.domain.usecase.GetDeviceByPkUseCase
import com.test.ezlo.domain.usecase.GetUserUseCase
import com.test.ezlo.domain.usecase.SaveDeviceUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DetailsScreenState(
    val mode: DetailsScreenMode,
    val device: DeviceUi? = null,
    val user: User? = null,
)

class DetailsViewModel @AssistedInject constructor(
    @Assisted private val mode: String,
    @Assisted private val pKDevice: Int,
    private val getDeviceByPkUseCase: GetDeviceByPkUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val saveDeviceUseCase: SaveDeviceUseCase,
) : ViewModel() {

    private val _state =
        MutableStateFlow(DetailsScreenState(mode = DetailsScreenMode.valueOf(mode)))
    val state = _state.asStateFlow()

    init {
        loadUser()
        loadDevice(pKDevice)
    }

    fun onDeviceTitleChange(title: String) {
        viewModelScope.launch {
            _state.emit(state.value.copy(device = state.value.device?.copy(title = title)))
        }
    }

    fun onSaveClick() {
        viewModelScope.launch {
            val device = state.value.device ?: return@launch
            saveDeviceUseCase.execute(
                UpdateDeviceParam(
                    pKDevice = device.pKDevice,
                    title = device.title
                )
            )
        }
    }

    private fun loadUser() {
        viewModelScope.launch {
            val result = getUserUseCase.execute()

            _state.emit(state.value.copy(user = result))
        }
    }

    private fun loadDevice(pKDevice: Int) {
        viewModelScope.launch {
            val result = getDeviceByPkUseCase.execute(pKDevice)
                ?.toUiModel() ?: return@launch

            _state.emit(state.value.copy(device = result))
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(screenMode: String, pKDevice: Int): DetailsViewModel
    }
}