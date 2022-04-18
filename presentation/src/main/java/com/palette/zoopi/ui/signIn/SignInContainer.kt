package com.palette.zoopi.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.palette.zoopi.R
import com.palette.zoopi.component.CustomIconButton

@Composable
fun SignInContainer(
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
            signUpBtnClick = { TODO("회원가입 페이지로 이동") }
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
                iconColor = Color(0xFF191919),
                buttonColor = Color(0xFFFEE500),
                text = "카카오로 시작하기",
                textColor = Color(0xFF191919),
                onClick = kakaoBtnClick
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Surface(modifier = Modifier.padding(horizontal = 16.dp)) {
            CustomIconButton(
                icon = painterResource(id = R.drawable.ic_logo_naver),
                iconColor = Color.White,
                buttonColor = Color(0xFF03C75A),
                text = "네이버로 시작하기",
                textColor = Color.White,
                onClick = naverBtnClick
            )
        }

        Spacer(modifier = Modifier.size(40.dp))

        Text(
            text = "아직 회원이 아니신가요?",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { signUpBtnClick() },
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInContainerPreview() {
    SignInContainer(rememberNavController())
}