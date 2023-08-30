package com.test.ezlo.feature.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.test.ezlo.R
import com.test.ezlo.core_ui.composable.UserProfileBlock

private const val DEVICE_PHOTO_SIZE = 80
private const val IMAGE_CORNER_SHAPE = 15
private const val LIST_PADDING = 15
private const val USER_BLOCK_HEIGHT = 250

@Composable
fun HomeScreen(
    vm: HomeViewModel,
    onEditClick: (pKDevice: Int) -> Unit,
    onItemClick: (pKDevice: Int) -> Unit,
    onItemLongClick: (pKDevice: Int) -> Unit,
) {

    val state by vm.state.collectAsStateWithLifecycle()

    HomeScreenContent(
        state = state,
        onEditClick = { onEditClick(it.pKDevice) },
        onItemClick = { onItemClick(it.pKDevice) },
        onItemLongClick = { onItemLongClick(it.pKDevice) },
        onResetClick = vm::loadDevices
    )
}

@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    onEditClick: (DeviceUi) -> Unit,
    onItemClick: (DeviceUi) -> Unit,
    onItemLongClick: (DeviceUi) -> Unit,
    onResetClick: () -> Unit
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(LIST_PADDING.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Button(onClick = onResetClick) {
                Text(text = stringResource(R.string.reset))
            }
        }

        item {
            UserProfileBlock(user = state.user, modifier = Modifier.height(USER_BLOCK_HEIGHT.dp))
        }

        items(state.devices, key = { it.pKDevice }) {
            DeviceListItem(
                deviceUi = it,
                onEditClick = onEditClick,
                onItemClick = onItemClick,
                modifier = Modifier.fillMaxWidth(),
                onItemLongClick = onItemLongClick,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DeviceListItem(
    deviceUi: DeviceUi,
    modifier: Modifier = Modifier,
    onEditClick: (DeviceUi) -> Unit,
    onItemClick: (DeviceUi) -> Unit,
    onItemLongClick: (DeviceUi) -> Unit,
) {
    Row(
        modifier = modifier.combinedClickable(
            onClick = { onItemClick(deviceUi) },
            onLongClick = { onItemLongClick(deviceUi) },
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = deviceUi.image),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = LIST_PADDING.dp)
                .requiredSize(DEVICE_PHOTO_SIZE.dp)
                .clip(RoundedCornerShape(IMAGE_CORNER_SHAPE.dp))
                .background(Color.Gray)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = deviceUi.title, fontWeight = FontWeight.Bold)
            Text(text = "SN: ${deviceUi.pKDevice}")
        }

        IconButton(onClick = { onEditClick(deviceUi) }) {
            Image(Icons.Filled.Edit, contentDescription = null)
        }
    }
}