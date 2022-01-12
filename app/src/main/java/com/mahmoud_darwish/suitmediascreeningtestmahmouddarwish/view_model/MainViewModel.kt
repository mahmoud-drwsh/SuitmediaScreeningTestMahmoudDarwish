package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.view_model

import androidx.lifecycle.ViewModel
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.Resource
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.api.Service
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    service: Service
) : ViewModel() {

    val userName: Flow<String> = flow { emit("Mahmoud Darwish") }

    val users = flow {
        emit(Resource.Loading)

        val users: List<User> = service.getUsers().users

        if (users.isEmpty())
            emit(Resource.Error("No records were found"))
        else
            emit(Resource.Success(users))

    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Unexpected error"))
    }
}