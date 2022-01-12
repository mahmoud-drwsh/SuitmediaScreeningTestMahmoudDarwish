package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.Preconditions
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.User
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.theme.buttonBackground

@Preview(showBackground = true)
@Composable
fun Third(
    navigationIcon: @Composable () -> Unit = {},
    users: List<User> = listOf()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Third Screen") },
                navigationIcon = navigationIcon
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.padding(it)
        ) {
            items(users) { user ->
                UserRowItem(user)
            }
        }
    }
}

@Composable
fun UserRowItem(user: User) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(Modifier.size(32.dp))
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "${user.firstName} ${user.lastName}")
            Text(text = user.email)
        }
    }
}
