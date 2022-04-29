package com.palette.zoopi.ui.signUp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.palette.zoopi.R
import com.palette.zoopi.component.BackButton
import com.palette.zoopi.component.RectangleButton
import com.palette.zoopi.component.ZoopiTextField
import com.palette.zoopi.ui.theme.Header
import kotlin.math.abs

@Composable
fun SignUpAuthenticatePhone(
    toPrevious: () -> Unit,
    toNextStep: () -> Unit
) {
    var authenticatePhoneStep: SignUpStep.AuthenticatePhone by remember {
        mutableStateOf(SignUpStep.AuthenticatePhone.WIRE_SERVICE)
    }
    val wireServiceOffset by
    animateDpAsState(
        (abs(SignUpStep.AuthenticatePhone.WIRE_SERVICE.offsetIndex - authenticatePhoneStep.offsetIndex) * 57).dp
    )
    val phoneNumberOffset by
    animateDpAsState(
        (abs(0.coerceAtMost(SignUpStep.AuthenticatePhone.PHONE_NUMBER.offsetIndex - authenticatePhoneStep.offsetIndex)) * 57).dp
    )
    val verificationCodeOffset by
    animateDpAsState(
        (abs(0.coerceAtMost(SignUpStep.AuthenticatePhone.VERIFICATION_CODE.offsetIndex - authenticatePhoneStep.offsetIndex)) * 57).dp
    )
    val nameOffset by
    animateDpAsState(
        (abs(0.coerceAtMost(SignUpStep.AuthenticatePhone.NAME.offsetIndex - authenticatePhoneStep.offsetIndex)) * 57).dp
    )

    val nextButtonClick = {
        when (authenticatePhoneStep) {
            SignUpStep.AuthenticatePhone.WIRE_SERVICE -> authenticatePhoneStep =
                SignUpStep.AuthenticatePhone.PHONE_NUMBER
            SignUpStep.AuthenticatePhone.PHONE_NUMBER -> authenticatePhoneStep =
                SignUpStep.AuthenticatePhone.VERIFICATION_CODE
            SignUpStep.AuthenticatePhone.VERIFICATION_CODE -> authenticatePhoneStep =
                SignUpStep.AuthenticatePhone.NAME
            SignUpStep.AuthenticatePhone.NAME -> authenticatePhoneStep =
                SignUpStep.AuthenticatePhone.RECHECK_INFO
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
            Crossfade(targetState = authenticatePhoneStep) {
                Header(text = it.title)
            }
            Spacer(Modifier.height(57.dp))
            AnimatedVisibility(
                visible = authenticatePhoneStep.offsetIndex >= SignUpStep.AuthenticatePhone.NAME.offsetIndex,
                enter = fadeIn(tween(250))
            ) {
                ZoopiTextField(
                    placeHolder = stringResource(id = R.string.name),
                    value = "김여진",
                    onValueChange = {},
                    modifier = Modifier.offset(y = nameOffset)
                )
            }
            AnimatedVisibility(
                visible = authenticatePhoneStep.offsetIndex >= SignUpStep.AuthenticatePhone.VERIFICATION_CODE.offsetIndex,
                enter = fadeIn(tween(250))
            ) {
                ZoopiTextField(
                    placeHolder = stringResource(id = R.string.verification_code),
                    value = "56364",
                    onValueChange = {},
                    modifier = Modifier.offset(y = verificationCodeOffset)
                )
            }
            AnimatedVisibility(
                visible = authenticatePhoneStep.offsetIndex >= SignUpStep.AuthenticatePhone.PHONE_NUMBER.offsetIndex,
                enter = fadeIn(tween(250))
            ) {
                ZoopiTextField(
                    placeHolder = stringResource(id = R.string.phone_number),
                    value = "010 1234 5678",
                    onValueChange = {},
                    modifier = Modifier.offset(y = phoneNumberOffset)
                )
            }
            ZoopiTextField(
                placeHolder = stringResource(id = R.string.select_wire_service),
                resetButtonVisible = false,
                value = "SKT",
                onClick = {},
                onValueChange = {},
                modifier = Modifier.offset(y = wireServiceOffset)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        RectangleButton(text = stringResource(id = R.string.next), onClick = nextButtonClick)
    }
}

@Composable
@Preview
fun SignUpAuthenticatePhone_Preview() {
    SignUpAuthenticatePhone({

    }) {

    }
}