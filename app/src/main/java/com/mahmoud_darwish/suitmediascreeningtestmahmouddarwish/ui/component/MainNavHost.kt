package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, Destinations.Home.route) {
        Destinations.getDestinations().forEach { dest ->
            composable(dest.route) {
                dest.Content(it, navController)
            }
        }
    }
}