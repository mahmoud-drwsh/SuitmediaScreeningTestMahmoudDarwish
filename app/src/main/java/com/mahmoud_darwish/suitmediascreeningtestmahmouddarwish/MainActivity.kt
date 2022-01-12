package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.theme.SuitmediaScreeningTestMahmoudDarwishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuitmediaScreeningTestMahmoudDarwishTheme {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Home() {
    Box(Modifier.fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}