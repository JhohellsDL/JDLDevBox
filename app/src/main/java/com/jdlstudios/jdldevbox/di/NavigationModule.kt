package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.navigation.AppNavigator
import com.jdlstudios.jdldevbox.navigation.AppNavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    single<AppNavigator> { AppNavigatorImpl() }
}
