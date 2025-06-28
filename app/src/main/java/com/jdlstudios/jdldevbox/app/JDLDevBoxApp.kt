package com.jdlstudios.jdldevbox.app

import android.app.Application
import com.jdlstudios.jdldevbox.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JDLDevBoxApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JDLDevBoxApp)
            modules(appModule)
        }

    }
}