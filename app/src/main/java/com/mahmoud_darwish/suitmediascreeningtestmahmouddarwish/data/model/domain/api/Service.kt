package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.api

import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("users")
    fun getMovies(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10,
    ): Flow<ApiResponse>
}

