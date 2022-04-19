package com.palette.zoopi.ui.signUp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.palette.zoopi.R
import com.palette.zoopi.component.BackButton
import com.palette.zoopi.component.RectangleButton
import com.palette.zoopi.component.ZoopiTextField
import com.palette.zoopi.ui.theme.Body1
import com.palette.zoopi.ui.theme.Header

@Composable
fun SignUpEmailPassword(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var emailPasswordStep: SignUpStep.EmailPassword by remember {
        mutableStateOf(SignUpStep.EmailPassword.EMAIL)
    }
    val emailOffset by
    animateDpAsState(if (emailPasswordStep == SignUpStep.EmailPassword.PASSWORD) 57.dp else 0.dp)

    val nextButtonClick =  {
        when (emailPasswordStep) {
            SignUpStep.EmailPassword.EMAIL -> emailPasswordStep =
                SignUpStep.EmailPassword.PASSWORD
            SignUpStep.EmailPassword.PASSWORD -> toNextStep()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(Modifier.height(34.dp))
            BackButton(onClick = toPrevious)
            Spacer(Modifier.height(36.dp))
            Crossfade(targetState = emailPasswordStep) {
                Header(text = it.title)
            }
            Spacer(Modifier.height(57.dp))
            AnimatedVisibility(
                visible = emailPasswordStep == SignUpStep.EmailPassword.PASSWORD,
                enter = fadeIn(tween(250))
            ) {
                ZoopiTextField(
                    placeHolder = stringResource(id = R.string.password),
                    value = "doitnow0!",
                    onValueChange = {},
                    isPassword = true
                )
            }
            ZoopiTextField(
                placeHolder = stringResource(id = R.string.email),
                value = "pjh00098@gmail.com",
                onValueChange = {},
                modifier = Modifier.offset(y = emailOffset)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        RectangleButton(text = stringResource(id = R.string.next), onClick = nextButtonClick)
    }
}

@Composable
@Preview
fun SignUpEmailPreview() {
    SignUpEmailPassword(toPrevious = {

    }) {

    }
}