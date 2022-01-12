package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.theme.buttonBackground

@Preview(showBackground = true)
@Composable
fun Second(
    navigationIcon: @Composable () -> Unit = {},
    name: String = "Mahmoud Darwish",
    showUsersList: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Second Screen") },
                navigationIcon = navigationIcon
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {
            val text = "Selected user name"

            Text(text = "Welcome", style = MaterialTheme.typography.body2)
            Text(text = name, style = MaterialTheme.typography.h6)

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }


            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = showUsersList,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = buttonBackground,
                    contentColor = Color.White
                )
            ) { Text(text = "Choose a user") }
        }
    }
}