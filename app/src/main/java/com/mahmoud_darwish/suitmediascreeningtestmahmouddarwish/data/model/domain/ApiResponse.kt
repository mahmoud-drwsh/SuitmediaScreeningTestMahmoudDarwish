package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val `data`: List<User> = listOf(),
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0
)