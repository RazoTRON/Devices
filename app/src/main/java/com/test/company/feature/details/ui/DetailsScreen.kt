package com.test.company.feature.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.test.company.R
import com.test.company.core_ui.composable.UserProfileBlock
import com.test.company.feature.details.common.DetailsScreenMode

private const val DEVICE_PHOTO_SIZE = 80
private const val IMAGE_CORNER_SHAPE = 15
private const val IMAGE_PADDING = 15
private const val DETAILS_BLOCK_PADDING = 15
private const val USER_BLOCK_HEIGHT = 250

@Composable
fun DetailsScreen(
    vm: DetailsViewModel,
    onMoveBack: () -> Unit
) {

    val state by vm.state.collectAsStateWithLifecycle()

    DetailsScreenContent(
        state = state,
        onTitleChange = vm::onDeviceTitleChange,
        onSaveClick = {
            vm.onSaveClick()
            onMoveBack()
        }
    )
}

@Composable
fun DetailsScreenContent(
    state: DetailsScreenState,
    onTitleChange: (String) -> Unit,
    onSaveClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.user != null) {
            UserProfileBlock(
                user = state.user,
                modifier = Modifier
                    .height(USER_BLOCK_HEIGHT.dp)
                    .fillMaxWidth()
            )
        }
        if (state.device != null) {
            Column(
                modifier = Modifier.padding(horizontal = DETAILS_BLOCK_PADDING.dp)
            ) {
                DeviceCard(
                    deviceUi = state.device,
                    mode = state.mode,
                    modifier = Modifier.padding(bottom = 10.dp),
                    onTitleChange = onTitleChange
                )

                Text(text = "SN: ${state.device.pKDevice}")
                Text(
                    text = "MAC Address: ${state.device.macAddress}",
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Text(text = "Firmware: ${state.device.firmware}")
                Text(
                    text = "Model: ${state.device.model}",
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                if (state.mode == DetailsScreenMode.EDIT) {
                    Button(onClick = onSaveClick, modifier = Modifier.fillMaxWidth()) {
                        Text(text = stringResource(R.string.save))
                    }
                }
            }
        }
    }
}

@Composable
fun DeviceCard(
    deviceUi: DeviceUi,
    mode: DetailsScreenMode,
    modifier: Modifier = Modifier,
    onTitleChange: (String) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = deviceUi.image),
            contentDescription = null,
            modifier = Modifier
                .padding(end = IMAGE_PADDING.dp)
                .requiredSize(DEVICE_PHOTO_SIZE.dp)
                .clip(RoundedCornerShape(IMAGE_CORNER_SHAPE.dp))
                .background(Color.Gray)
        )

        when (mode) {
            DetailsScreenMode.VIEW -> {
                Text(
                    text = deviceUi.title,
                    fontWeight = FontWeight.Bold,
                )
            }

            DetailsScreenMode.EDIT -> {
                TextField(value = deviceUi.title, onValueChange = onTitleChange)
            }
        }
    }
}