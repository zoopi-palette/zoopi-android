package com.palette.zoopi.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.palette.zoopi.R
import com.palette.zoopi.component.CustomIconButton
import com.palette.zoopi.ui.base.NavGroup
import com.palette.zoopi.ui.theme.Grey60
import com.palette.zoopi.ui.theme.NaverGreen

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

        SignInButtons(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.BottomCenter)
                .padding(bottom = 72.dp),
            kakaoBtnClick = { TODO("카카오로 로그인") },
            naverBtnClick = { TODO("네이버로 로그인") },
            signUpBtnClick = { navController.navigate(NavGroup.Authentication.SIGN_UP_EMAIL_PASSWORD) }
        )
    }
}

@Composable
fun SignInButtons(
    modifier: Modifier,
    kakaoBtnClick: () -> Unit,
    naverBtnClick: () -> Unit,
    signUpBtnClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Surface(modifier = Modifier.padding(horizontal = 16.dp)) {
            CustomIconButton(
                icon = painterResource(id = R.drawable.ic_logo_kakao),
                iconColor = Color.Black,
                buttonColor = Yellow,
                text = "카카오로 시작하기",
                textColor = Color.Black,
                onClick = kakaoBtnClick
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Surface(modifier = Modifier.padding(horizontal = 16.dp)) {
            CustomIconButton(
                icon = painterResource(id = R.drawable.ic_logo_naver),
                iconColor = Color.White,
                buttonColor = NaverGreen,
                text = "네이버로 시작하기",
                textColor = Color.White,
                onClick = naverBtnClick
            )
        }

        Spacer(modifier = Modifier.size(40.dp))

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
