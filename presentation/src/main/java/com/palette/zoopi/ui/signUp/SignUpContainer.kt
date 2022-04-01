package com.palette.zoopi.ui.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.palette.zoopi.R
import com.palette.zoopi.ui.theme.Header

@Composable
fun SignUpContainer(
    navigateToAuthHome: () -> Unit
) {
    Column {
        Image(
            modifier = Modifier.padding(start = 20.dp, top = 34.dp),
            painter = painterResource(id = R.drawable.all_ic_back),
            contentDescription = stringResource(id = R.string.back_button)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Header(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "이메일을 입력해주세요")
    }
}


@Composable
@Preview(name = "Sign Up Container", showBackground = true, showSystemUi = true)
fun SignUpContainer_Preview() {
    SignUpContainer {

    }
}