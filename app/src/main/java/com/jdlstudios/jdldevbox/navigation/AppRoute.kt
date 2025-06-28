package com.jdlstudios.jdldevbox.navigation

sealed class AppRoute(val route: String) {
    object Splash : AppRoute("splash")
    object Home : AppRoute("home")
    object Meta : AppRoute("meta")
    object Categories : AppRoute("categories")
    object CategoryDetails : AppRoute("category_details/{categoryId}") {
        fun createRoute(categoryId: String) = "category_details/$categoryId"
    }
    object Settings : AppRoute("settings")
    object About : AppRoute("about")
}
