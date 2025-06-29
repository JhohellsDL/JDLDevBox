package com.jdlstudios.jdldevbox.navigation

import android.util.Log // Importar Log
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
        Log.d("AppNavHost", "LaunchedEffect started, collecting navEvents.")
        appNavigator.navEvents.collect { event ->
            Log.d("AppNavHost", "Collected NavEvent: $event")
            when (event) {
                NavEvent.NavigateToHome -> {
                    Log.d("AppNavHost", "Navigating to Home. Popping up to Splash.")
                    navController.navigate(AppRoute.Home.route) {
                        popUpTo(AppRoute.Splash.route) { inclusive = true }
                    }
                }
                is NavEvent.NavigateToCategoryDetailScreen -> {
                    Log.d("AppNavHost", "Navigating to CategoryDetailScreen: ${event.categoryId}")
                    navController.navigate(AppRoute.CategoryDetails.createRoute(event.categoryId))
                }
                NavEvent.NavigateToMetaScreen -> {
                    Log.d("AppNavHost", "Navigating to MetaScreen.")
                    navController.navigate(AppRoute.Meta.route)
                }
                NavEvent.NavigateToCategoriesScreen -> {
                    Log.d("AppNavHost", "Navigating to CategoriesScreen.")
                    navController.navigate(AppRoute.Categories.route)
                }
                NavEvent.NavigateToToolsScreen -> {
                    Log.d("AppNavHost", "Navigating to ToolsScreen.")
                    navController.navigate(AppRoute.Tools.route)
                }
                NavEvent.NavigateToSettingsScreen -> {
                    Log.d("AppNavHost", "Navigating to SettingsScreen.")
                    navController.navigate(AppRoute.Settings.route)
                }
                NavEvent.NavigateToAboutScreen -> {
                    Log.d("AppNavHost", "Navigating to AboutScreen.")
                    navController.navigate(AppRoute.About.route)
                }
                else -> {
                    Log.w("AppNavHost", "Unhandled NavEvent: $event")
                }
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