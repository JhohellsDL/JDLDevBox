package com.jdlstudios.jdldevbox.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.koin.compose.koinInject

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    appNavigator: AppNavigator = koinInject()
) {
    LaunchedEffect(Unit) {
        appNavigator.navEvents.collect { event ->
            when (event) {
                NavEvent.NavigateToHome -> {
                    navController.navigate(AppRoute.Home.route) {
                        popUpTo(AppRoute.Splash.route) { inclusive = true }
                    }
                }
                is NavEvent.NavigateToCategoryDetailScreen -> {
                    navController.navigate(AppRoute.CategoryDetails.createRoute(event.categoryId))
                }
                NavEvent.NavigateToMetaScreen -> navController.navigate(AppRoute.Meta.route)
                NavEvent.NavigateToCategoriesScreen -> navController.navigate(AppRoute.Categories.route)
                NavEvent.NavigateToSettingsScreen -> navController.navigate(AppRoute.Settings.route)
                NavEvent.NavigateToAboutScreen -> navController.navigate(AppRoute.About.route)
                else -> {}
            }
        }
    }

    Scaffold { innerPadding ->
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}