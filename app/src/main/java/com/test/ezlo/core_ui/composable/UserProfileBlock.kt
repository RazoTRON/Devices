package com.test.ezlo.core_ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.ezlo.core_ui.theme.EZLOTheme
import com.test.ezlo.domain.model.User

private const val PHOTO_SIZE = 100

@Composable
fun UserProfileBlock(user: User, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.requiredSize(PHOTO_SIZE.dp)
            )
            Text(
                text = "${user.firstName} ${user.lastName}",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileBlockPreview() {
    EZLOTheme {
        UserProfileBlock(
            User(
                id = 0,
                firstName = "Vladyslav",
                lastName = "Mihalatiuk",
                photoUrl = ""
            )
        )
    }
}