package com.palette.zoopi.ui.signIn

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignInContainer(
    navController: NavController
) {
    TODO("sign in ui 구현하기")
}

@Preview(showBackground = true)
@Composable
fun SignInContainerPreview() {
    SignInContainer(rememberNavController())
}