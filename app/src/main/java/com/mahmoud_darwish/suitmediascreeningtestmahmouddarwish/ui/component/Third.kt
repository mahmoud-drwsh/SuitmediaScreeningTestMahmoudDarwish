package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component.utils.CoilImage

@Composable
fun UserRowItem(user: User, onItemClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onItemClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CoilImage(url = user.avatar, imageDescription = "User avatar")
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(text = "${user.firstName} ${user.lastName}")
            Text(text = user.email)
        }
    }
}
