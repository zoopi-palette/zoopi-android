package com.palette.zoopi.ui.signIn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.palette.zoopi.R
import com.palette.zoopi.component.AppBar
import com.palette.zoopi.component.RectangleButton
import com.palette.zoopi.component.ZoopiTextField

@Composable
fun SignInContainer(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var signInStep: SignInEmailStep by remember {
        mutableStateOf(SignInEmailStep.EMAIL)
    }

    val signInEmailOffset by animateDpAsState(if (signInStep == SignInEmailStep.PASSWORD) 57.dp else 0.dp)

    val clickNextBtn = {
        when (signInStep) {
            SignInEmailStep.EMAIL -> signInStep = SignInEmailStep.PASSWORD
            SignInEmailStep.PASSWORD -> toNextStep()
        }
    }

    var emailTextState by remember { mutableStateOf(String()) }
    var passwordTextState by remember { mutableStateOf(String()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            AppBar(onBackBtnClick = { toPrevious() }, text = "이메일 로그인")

            Spacer(modifier = Modifier.height(57.dp))

            AnimatedVisibility(
                visible = signInStep == SignInEmailStep.PASSWORD,
                enter = fadeIn(tween(250))
            ) {
                ZoopiTextField(
                    placeHolder = stringResource(id = R.string.password),
                    value = emailTextState,
                    isPassword = true,
                    onValueChange = { emailTextState = it }
                )
            }

            ZoopiTextField(
                placeHolder = stringResource(id = R.string.email),
                value = passwordTextState,
                onValueChange = { passwordTextState = it },
                modifier = Modifier.offset(y = signInEmailOffset)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        RectangleButton(text = stringResource(id = R.string.next), onClick = clickNextBtn)
    }
}

@Preview(showBackground = true)
@Composable
fun SignInContainerPreview() {
    SignInContainer({}) {}
}