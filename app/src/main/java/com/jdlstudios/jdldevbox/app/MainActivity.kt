package com.jdlstudios.jdldevbox.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jdlstudios.jdldevbox.navigation.AppNavHost
import com.jdlstudios.jdldevbox.ui.theme.JDLDevBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JDLDevBoxTheme {
                AppNavHost()
            }
        }
    }
}
