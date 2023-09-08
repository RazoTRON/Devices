package com.test.company.feature.home.ui.delete_dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.company.domain.usecase.DeleteDeviceUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

data class DeleteDialogState(
    val pkDevice: Int
)

class DeleteDialogViewModel @AssistedInject constructor(
    @Assisted private val pkDevice: Int,
    private val deleteDeviceUseCase: DeleteDeviceUseCase
) : ViewModel() {

    val state = DeleteDialogState(pkDevice)

    fun onDeleteDevice(pkDevice: Int) {
        viewModelScope.launch {
            deleteDeviceUseCase.execute(pkDevice)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(pkDevice: Int): DeleteDialogViewModel
    }
}