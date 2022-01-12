package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component.MainNavHost
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.theme.SuitmediaScreeningTestMahmoudDarwishTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { SuitmediaScreeningTestMahmoudDarwishTheme { MainNavHost() } }
    }
}


