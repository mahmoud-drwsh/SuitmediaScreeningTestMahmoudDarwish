package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component.utils

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.Resource

@Composable
fun <T> ResourceComposable(
    resource: Resource<T>,
    onSuccess: @Composable (T) -> Unit
) = when (resource) {
    is Resource.Error -> CenteredMessage(resource.message)
    is Resource.Loading -> CenteredContent {
        CircularProgressIndicator(modifier = Modifier.size(32.dp))
    }
    is Resource.Success -> onSuccess(resource.data)
}