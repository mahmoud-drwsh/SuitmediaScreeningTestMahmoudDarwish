package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.repo

import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.Resource
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.api.Service
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.User
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepo @Inject constructor(
    service: Service
) {

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
