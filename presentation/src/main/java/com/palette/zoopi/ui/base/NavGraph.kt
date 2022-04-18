package com.palette.zoopi.ui.base

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.palette.zoopi.ui.signIn.SignInContainer
import com.palette.zoopi.ui.theme.Header

// Authentication View Graph
fun NavGraphBuilder.authenticationGraph(navController: NavController) {
    navigation(startDestination = NavGroup.Authentication.AUTH_HOME, route = NavGroup.Authentication.group) {
        //Authentication Home Screen
        composable(route = NavGroup.Authentication.AUTH_HOME) {
            Header(text = "Hello Zoopi")
        }
        //Sign In Screen
        composable(route = NavGroup.Authentication.SIGN_IN) {
            SignInContainer(navController)
        }
        //Sign Up Screen
        composable(NavGroup.Authentication.SIGN_UP) {

        }
    }
}