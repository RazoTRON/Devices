package com.test.ezlo.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.test.ezlo.R

@Composable
fun DeleteDialogContent(
    viewModel: DeleteDialogViewModel,
    moveBack: () -> Unit,
) {
    DeleteDialogContent(
        pkDevice = viewModel.state.pkDevice,
        onConfirm = { _pkDevice ->
            viewModel.onDeleteDevice(_pkDevice)
            moveBack()
        },
        onDismiss = moveBack
    )
}

@Composable
fun DeleteDialogContent(
    pkDevice: Int,
    onConfirm: (pkDevice: Int) -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.delete_device_text),
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    Button(onClick = { onConfirm(pkDevice) }) {
                        Text(text = stringResource(R.string.delete))
                    }

                    Button(onClick = onDismiss) {
                        Text(text = stringResource(R.string.cancel))
                    }
                }
            }
        }
    }
}