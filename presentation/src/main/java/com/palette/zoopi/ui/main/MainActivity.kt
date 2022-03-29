package com.palette.zoopi.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.palette.zoopi.ui.base.NavGroup
import com.palette.zoopi.ui.base.authenticationGraph
import com.palette.zoopi.ui.theme.Header
import com.palette.zoopi.ui.theme.ZoopiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZoopiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ZoopiApp()
                }
            }
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZoopiApp() {
    val navController: NavHostController = rememberAnimatedNavController()
    NavHost(navController = navController, startDestination = NavGroup.Authentication.group) {
        // Authentication Group
        authenticationGraph(navController = navController)
    }
}