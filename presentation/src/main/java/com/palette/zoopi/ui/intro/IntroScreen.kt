package com.palette.zoopi.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.palette.zoopi.R
import com.palette.zoopi.component.CustomIconButton
import com.palette.zoopi.component.RectangleStrokeButton
import com.palette.zoopi.ui.base.NavGroup
import com.palette.zoopi.ui.theme.*

@Composable
fun IntroScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(top = 120.dp)
        )
        
        Spacer(modifier = Modifier.weight(1f))

        SignInButtons(
            signInKakaoBtnClick = { TODO("카카오로 로그인") },
            signInNaverBtnClick = { TODO("네이버로 로그인") },
            signInEmailBtnClick = { navController.navigate(NavGroup.Authentication.SIGN_IN) },
            signUpBtnClick = { navController.navigate(NavGroup.Authentication.SIGN_UP_EMAIL_PASSWORD) }
        )

        Spacer(modifier = Modifier.height(72.dp))
    }
}

@Composable
fun SignInButtons(
    signInKakaoBtnClick: () -> Unit,
    signInNaverBtnClick: () -> Unit,
    signInEmailBtnClick: () -> Unit,
    signUpBtnClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        CustomIconButton(
            icon = painterResource(id = R.drawable.ic_logo_kakao),
            iconColor = Color.Black,
            buttonColor = Yellow,
            text = "카카오로 시작하기",
            textColor = Color.Black,
        ) {
            signInKakaoBtnClick()
        }

        Spacer(modifier = Modifier.height(8.dp))

        CustomIconButton(
            icon = painterResource(id = R.drawable.ic_logo_naver),
            iconColor = Color.White,
            buttonColor = NaverGreen,
            text = "네이버로 시작하기",
            textColor = Color.White,
        ) {
            signInNaverBtnClick()
        }
        
        Spacer(modifier = Modifier.height(8.dp))

        RectangleStrokeButton(
            modifier = Modifier.height(48.dp),
            text = "이메일로 로그인",
            textColor = Grey50,
            strokeBorder = 1.dp,
            roundBorder = 12.dp,
            borderStrokeColor = Grey30,
            buttonColors = ButtonDefaults.buttonColors(
                backgroundColor = Grey10
            )
        ) {
            signInEmailBtnClick()
        }

        Spacer(modifier = Modifier.height(40.dp))

        TextButton(
            onClick = signUpBtnClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "아직 회원이 아니신가요?",
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                color = Grey60
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntroPreview() {
    IntroScreen(rememberNavController())
}
