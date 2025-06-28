package com.jdlstudios.jdldevbox.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class AppNavigatorImpl : AppNavigator {

    private val _navEvents = MutableSharedFlow<NavEvent>()
    override val navEvents = _navEvents.asSharedFlow()

    override fun navigate(event: NavEvent) {
        _navEvents.tryEmit(event)
    }
}