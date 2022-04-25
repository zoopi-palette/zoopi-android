package com.palette.zoopi.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.palette.zoopi.ui.theme.Header

@Composable
fun AppBar(
    onBackBtnClick: () -> Unit,
    text: String
) {
    Column {
        Spacer(modifier = Modifier.height(34.dp))

        Surface(
            modifier = Modifier.padding(start = 19.dp)
        ) {
            BackButton(onClick = onBackBtnClick)
        }

        Spacer(modifier = Modifier.height(36.dp))

        Header(text = text, modifier = Modifier.padding(start = 24.dp))
    }
}

@Preview
@Composable
fun PreviewAppBar() {
    AppBar(onBackBtnClick = { }, text = "이메일 로그인")
}

