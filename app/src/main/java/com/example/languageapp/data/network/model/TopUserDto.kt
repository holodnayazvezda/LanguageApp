package com.example.languageapp.data.network.model

import com.google.gson.annotations.SerializedName

data class TopUserDto(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("amount_of_points") val amountOfPoints: Int
)