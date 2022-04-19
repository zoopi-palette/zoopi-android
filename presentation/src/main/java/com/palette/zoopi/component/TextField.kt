package com.palette.zoopi.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.palette.zoopi.R
import com.palette.zoopi.ui.theme.*

@Composable
fun ZoopiTextField(
    modifier: Modifier = Modifier,
    placeHolder: String,
    value: String,
    error: String? = null,
    isPassword: Boolean = false,
    resetButtonVisible: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    var focused by remember {
        mutableStateOf(false)
    }
    val placeHolderSize: Dp by animateDpAsState(targetValue = if (focused || value.isNotEmpty()) 14.dp else 22.dp)
    val placeHolderYOffset: Dp by animateDpAsState(targetValue = if (focused || value.isNotEmpty()) (-24).dp else 0.dp)
    val interactionSource = remember { MutableInteractionSource() }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = if (onClick != null) modifier.clickable(onClick = onClick) else modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box {
                Text(
                    color = if (focused) Grey50 else Grey40,
                    text = placeHolder,
                    fontSize = placeHolderSize.value.sp,
                    modifier = Modifier.offset(y = placeHolderYOffset)
                )
                BasicTextField(
                    modifier = Modifier
                        .onFocusChanged {
                            focused = it.hasFocus
                        }
                        .height(32.dp)
                        .fillMaxWidth(0.8f),
                    value = value,
                    onValueChange = onValueChange,
                    maxLines = 1,
                    textStyle = TextStyle(
                        fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = spoqa,
                        fontWeight = FontWeight.Normal
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction
                    ),
                    visualTransformation = if (!passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                    enabled = onClick == null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if (isPassword) {
                Image(
                    imageVector = if (passwordVisible) Icons.Filled.Star else Icons.Outlined.Clear,
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            passwordVisible = !passwordVisible
                        }
                        .alpha(if (value.isNotEmpty()) 1f else 0f)
                        .padding(end = 14.dp),
                    contentDescription = "비밀번호 토글"
                )
            }
            if (resetButtonVisible) {
                Image(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { onValueChange("") },
                    painter = painterResource(id = R.drawable.all_input_close),
                    contentDescription = stringResource(id = R.string.input_close),
                    alpha = if (value.isNotEmpty()) 1f else 0f
                )
            }
        }
        Divider(
            modifier = Modifier
                .height(2.dp)
                .offset(y = (-4).dp),
            color = if (focused) Grey90 else Grey30
        )
        if (error != null) {
            Caption2(
                modifier = Modifier.padding(top = 2.dp),
                text = error,
                color = Error
            )
        }
    }
}

@Composable
@Preview(name = "Text Field Preview", showBackground = true)
fun ZoopiTextField_Preview() {
    var value by remember {
        mutableStateOf("123")
    }

    var value2 by remember {
        mutableStateOf("123")
    }
    Column {
        ZoopiTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            placeHolder = "이메일",
            value = value,
            onValueChange = {
                value = it
            }
        )
        ZoopiTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            placeHolder = "비밀번호",
            value = value2,
            error = "영문자(대/소)+숫자+특수문자 중 2가지 조합 10자리 이상",
            onValueChange = {
                value2 = it
            })
    }

}