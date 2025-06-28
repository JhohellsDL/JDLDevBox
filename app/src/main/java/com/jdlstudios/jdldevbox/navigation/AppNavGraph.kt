package com.jdlstudios.jdldevbox.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jdlstudios.jdldevbox.ui.screens.home.HomeScreen
import com.jdlstudios.jdldevbox.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Splash.route,
        modifier = modifier
    ) {
        composable(AppRoute.Splash.route) {
            SplashScreen()
        }
        composable(AppRoute.Home.route) {
            HomeScreen()
        }
    }

}