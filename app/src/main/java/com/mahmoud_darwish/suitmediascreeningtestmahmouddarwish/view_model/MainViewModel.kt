package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.view_model

import androidx.lifecycle.ViewModel
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.repo.UserNameRepo
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.api.Service
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.repo.UsersRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userNameRepo: UserNameRepo,
    usersRepo: UsersRepo
) : ViewModel() {

    val userName = userNameRepo.userName

    fun setUserName(value: String) = userNameRepo.setUserName(value)

    private val selectedUser = userNameRepo.selectedUser

    val selectedUserName = userNameRepo.selectedUser.map {
        if (it.firstName.isNotEmpty()) "${it.firstName} ${it.lastName}"
        else "A user has not been selected"
    }

    fun setSelectedUser(value: User) = userNameRepo.setSelectedUser(value)

    val users = usersRepo.users
}