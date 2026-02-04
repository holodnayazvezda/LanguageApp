package com.example.languageapp.domain.models

data class ExerciseModel(
    val id: Int,
    val name: String,
    val iconUrl: String, // Server will probably return URL or a type I map to local res
    val type: String // To identify which screen to open
)