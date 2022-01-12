package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.R
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.theme.buttonBackground

@Preview(showBackground = true)
@Composable
fun Home(
    name: MutableState<String> = remember { mutableStateOf("") },
    palindrome: MutableState<String> = remember { mutableStateOf("") },
    onCheckClick: (String) -> Unit = {},
    onNextClick: () -> Unit = {},
) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.Center),
        ) {
            Image(
                painterResource(id = R.drawable.btn_add_photo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(8.dp),
                value = name.value,
                onValueChange = name::value::set,
                label = { Text("Name") },
                visualTransformation = VisualTransformation.None,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            TextField(
                modifier =
                Modifier.fillMaxWidth(),
                value = palindrome.value,
                shape = RoundedCornerShape(8.dp),
                onValueChange = palindrome::value::set,
                label = { Text("Palindrome") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )

            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                onClick = { onCheckClick(palindrome.value) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = buttonBackground,
                    contentColor = Color.White
                )
            ) { Text(text = "Check") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onNextClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = buttonBackground,
                    contentColor = Color.White
                )
            ) { Text(text = "Next") }
        }
    }
}