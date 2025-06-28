package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.ui.screens.home.HomeViewModel
import com.jdlstudios.jdldevbox.ui.screens.metaconfig.MetaConfigViewModel
import com.jdlstudios.jdldevbox.ui.screens.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::MetaConfigViewModel)
    viewModelOf(::SplashViewModel)
}
