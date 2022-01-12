package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.repo

import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserNameRepo @Inject constructor() {
    val userName = MutableStateFlow("Mahmoud Darwish")

    fun setUserName(value: String) {
        userName.value = value
    }

    var selectedUser: MutableStateFlow<User> = MutableStateFlow(User())

    fun setSelectedUser(value: User) {
        selectedUser.value = value
    }
}
