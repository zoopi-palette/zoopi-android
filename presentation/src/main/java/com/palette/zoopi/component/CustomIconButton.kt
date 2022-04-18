package com.palette.zoopi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.palette.zoopi.R
import com.palette.zoopi.ui.theme.ZoopiTheme
import com.palette.zoopi.ui.theme.spoqa

@Composable
fun CustomIconButton(
    icon: Painter,
    iconColor: Color,
    buttonColor: Color,
    text: String,
    textColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .background(
                color = buttonColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter = icon, contentDescription = "icon", tint = iconColor)

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = textColor,
                    fontFamily = spoqa,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CustomIconButtonPreview() {
    ZoopiTheme {
        CustomIconButton(
            icon = painterResource(id = R.drawable.ic_logo_kakao),
            iconColor = Color.Black,
            buttonColor = Color.Yellow,
            text = "카카오로 시작하기",
            textColor = Color.Black,
            onClick = {}
        )
    }
}