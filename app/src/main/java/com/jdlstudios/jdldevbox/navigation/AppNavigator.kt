package com.jdlstudios.jdldevbox.navigation

import kotlinx.coroutines.flow.Flow

interface AppNavigator {
    val navEvents: Flow<NavEvent>
    fun navigate(event: NavEvent)
}