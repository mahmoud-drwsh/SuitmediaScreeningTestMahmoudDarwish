package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.api

import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.remote.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("users")
    fun getUsers(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10,
    ): ApiResponse
}

