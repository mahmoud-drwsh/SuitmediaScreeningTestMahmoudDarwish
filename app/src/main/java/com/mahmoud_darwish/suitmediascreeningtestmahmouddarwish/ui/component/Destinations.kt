package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.Resource
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.getPalindromeCheckerDialogMessage
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.ui.component.utils.ResourceComposable
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
            val viewModel = hiltViewModel<MainViewModel>()

            val userName by viewModel.userName.collectAsState("")

            var isPalindromeMessage by remember { mutableStateOf("") }
            var showDialog by remember { mutableStateOf(false) }

            if (showDialog)
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) { Text(text = "Dismiss") }
                    },
                    title = { Text(isPalindromeMessage) }
                )

            Home(
                name = userName,
                onCheckClick = { string: String ->
                    isPalindromeMessage = getPalindromeCheckerDialogMessage(string)
                    showDialog = true
                },
                onNextClick = { navController.navigate(Second.route) },
                onChangeUserName = viewModel::setUserName
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

            val selectedUserName by viewModel.selectedUserName.collectAsState("")

            Second(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Navigate back")
                    }
                },
                name = userName,
                showUsersList = { navController.navigate(Third.route) },
                selectedUserName = selectedUserName
            )
        }
    }

    object Third : Destinations() {
        override val route: String = "third"

        @Composable
        override fun Content(stackEntry: NavBackStackEntry, navController: NavHostController) {
            val viewModel = hiltViewModel<MainViewModel>()

            val users: Resource<List<User>> by viewModel.users.collectAsState(initial = Resource.Loading)

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Third Screen") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Navigate back")
                            }
                        }
                    )
                }
            ) { padding ->
                ResourceComposable(users) { list ->
                    LazyColumn(
                        contentPadding = PaddingValues(8.dp),
                        modifier = Modifier.padding(padding)
                    ) {
                        items(items = list) { user ->
                            UserRowItem(user) {
                                viewModel.setSelectedUser(user)
                                navController.navigateUp()
                            }
                        }
                    }
                }
            }
        }


    }

    companion object {
        fun getDestinations() = listOf(Home, Second, Third)
    }
}