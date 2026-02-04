package com.example.languageapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ExerciseDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("type") val type: String
)