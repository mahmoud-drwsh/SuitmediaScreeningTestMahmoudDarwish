package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.view_model

import androidx.lifecycle.ViewModel
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.Resource
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.User
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.api.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    service: Service
) : ViewModel() {

    val userName: Flow<String> = flow { emit("Mahmoud Darwish") }

    val users = service.getUsers().map {
        val users: List<User> = it.data

        if (users.isEmpty())
            Resource.Error("No records were found")
        else
            Resource.Success(users)

    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Unexpected error"))
    }
}