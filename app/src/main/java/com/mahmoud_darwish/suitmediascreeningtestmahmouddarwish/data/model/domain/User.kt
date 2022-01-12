package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("last_name")
    val lastName: String = ""
)