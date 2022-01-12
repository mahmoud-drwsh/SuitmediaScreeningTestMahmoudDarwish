package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.Resource
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.getPalindromeCheckerDialogMessage
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.view_model.MainViewModel

sealed class Destinations {
    abstract val route: String

    @Composable
    abstract fun Content(
        stackEntry: NavBackStackEntry,
        navController: NavHostController
    )

    object Home : Destinations() {
        override val route: String = "home"

        @Composable
        override fun Content(
            stackEntry: NavBackStackEntry,
            navController: NavHostController
        ) {
            var isPalindromeMessage by remember { mutableStateOf("") }
            var showDialog by remember { mutableStateOf(false) }

            if (showDialog)
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) { Text(text = "Dismiss") }
                    },
                    text = { Text(isPalindromeMessage) }
                )

            Home(
                onCheckClick = { string: String ->
                    isPalindromeMessage = getPalindromeCheckerDialogMessage(string)
                    showDialog = true
                },
                onNextClick = { navController.navigate(Second.route) }
            )
        }
    }

    object Second : Destinations() {
        override val route: String = "second"

        @Composable
        override fun Content(
            stackEntry: NavBackStackEntry,
            navController: NavHostController
        ) {
            val viewModel = hiltViewModel<MainViewModel>()
            val userName by viewModel.userName.collectAsState("")

            Second(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Navigate back")
                    }
                },
                name = userName,
                showUsersList = { navController.navigate(Third.route) }
            )
        }
    }

    object Third : Destinations() {
        override val route: String = "third"

        @Composable
        override fun Content(stackEntry: NavBackStackEntry, navController: NavHostController) {
            val viewModel = hiltViewModel<MainViewModel>()

            val users: Resource<List<User>> by viewModel.users.collectAsState(initial = Resource.Loading)

            when (users) {
                is Resource.Error -> {
                    val error = users as Resource.Error

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(error.message)
                    }
                }
                is Resource.Loading -> CircularProgressIndicator(modifier = Modifier.size(32.dp))
                is Resource.Success -> {
                    val success = users as Resource.Success

                    Third(
                        navigationIcon = {
                            IconButton(
                                onClick = { navController.navigateUp() }
                            ) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Navigate back")
                            }
                        },
                        users = success.data
                    )

                }
            }
        }
    }

    companion object {
        fun getDestinations() = listOf(Home, Second, Third)
    }
}