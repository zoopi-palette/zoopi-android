package com.palette.zoopi.ui.base

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.palette.zoopi.ui.signUp.SignUpAuthenticatePhone
import com.palette.zoopi.ui.signUp.SignUpEmailPassword
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.palette.zoopi.ui.intro.IntroScreen
import com.palette.zoopi.ui.signIn.SignInContainer
import com.palette.zoopi.ui.theme.Header

// Authentication View Graph
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.authenticationGraph(navController: NavController) {
    navigation(
        startDestination = NavGroup.Authentication.AUTH_HOME,
        route = NavGroup.Authentication.group
    ) {
        //Authentication Home Screen
        composable(route = NavGroup.Authentication.AUTH_HOME, enterTransition = null) {
            IntroScreen(navController = navController)
        }
        //Sign In Screen
        composable(route = NavGroup.Authentication.SIGN_IN, enterTransition = null) {
            SignInContainer(navController = navController)
        }
        //Sign up Email Password Step
        composable(NavGroup.Authentication.SIGN_UP_EMAIL_PASSWORD,
            enterTransition = {
                if (this.initialState.destination.route.equals(NavGroup.Authentication.AUTH_HOME)) slideInHorizontally(
                    initialOffsetX = { 1500 },
                    animationSpec = tween(250)
                )
                else slideInHorizontally(initialOffsetX = { -1500 }, animationSpec = tween(250))

            }, exitTransition = {
                if (this.targetState.destination.route.equals(NavGroup.Authentication.SIGN_UP_AUTHENTICATE_PHONE))
                    slideOutHorizontally(targetOffsetX = { -1500 }, animationSpec = tween(250))
                else slideOutHorizontally(targetOffsetX = { 1500 }, animationSpec = tween(250))
            }) {
            SignUpEmailPassword(toPrevious = {
            }) {
                navController.navigate(route = NavGroup.Authentication.SIGN_UP_AUTHENTICATE_PHONE)
            }
        }
        //Sign up Authenticate Phone
        composable(NavGroup.Authentication.SIGN_UP_AUTHENTICATE_PHONE,
            enterTransition = {
                if (this.initialState.destination.route.equals(NavGroup.Authentication.SIGN_UP_EMAIL_PASSWORD)) slideInHorizontally(
                    initialOffsetX = { 1500 },
                    animationSpec = tween(250)
                )
                else slideInHorizontally(initialOffsetX = { -1500 }, animationSpec = tween(250))
            }, exitTransition = {
                if (this.targetState.destination.route.equals(NavGroup.Authentication.AUTH_HOME))
                    slideOutHorizontally(targetOffsetX = { -1500 }, animationSpec = tween(250))
                else slideOutHorizontally(targetOffsetX = { 1500 }, animationSpec = tween(250))
            }) {
            SignUpAuthenticatePhone(toPrevious = {
                navController.navigate(route = NavGroup.Authentication.SIGN_UP_EMAIL_PASSWORD)
            }) {

            }
        }
    }
}