package com.example.languageapp.domain.models

data class UserModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatarUrl: String?
)