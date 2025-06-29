package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.ui.screens.home.HomeViewModel
import com.jdlstudios.jdldevbox.ui.screens.metaconfig.MetaConfigViewModel
import com.jdlstudios.jdldevbox.ui.screens.splash.SplashViewModel
import com.jdlstudios.jdldevbox.ui.screens.tools.ToolsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { MetaConfigViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { ToolsViewModel(get()) }
}
