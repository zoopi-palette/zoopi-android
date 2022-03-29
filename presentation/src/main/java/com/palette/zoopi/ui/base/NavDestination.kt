package com.palette.zoopi.ui.base

//Navigation Group
sealed class NavGroup(val group: String) {
    //Authentication associated group
    object Authentication: NavGroup("Authentication") {
        const val AUTH_HOME = "authHome"
        const val SIGN_IN = "signIn"
        const val SIGN_UP = "signUp"
    }
}