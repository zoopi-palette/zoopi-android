package com.palette.zoopi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.palette.zoopi.R
import com.palette.zoopi.ui.theme.Body1
import com.palette.zoopi.ui.theme.Main1

@Composable
fun BackButton(
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Image(
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        painter = painterResource(id = R.drawable.all_ic_back),
        contentDescription = stringResource(
            id = R.string.previous
        )
    )
}

@Composable
fun RectangleButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.White,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = Main1
    ),
    onClick: () -> Unit
) {
    Button(
        shape = RectangleShape,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        colors = buttonColors
    ) {
        Body1(text = text, color = textColor)
    }
}

@Composable
@Preview
fun ButtonPreview() {
    BackButton {

    }

    RectangleButton(text = "닫기") {

    }
}