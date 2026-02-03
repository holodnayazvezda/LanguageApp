package com.example.languageapp.domain.models

data class LeaderBoardModel(
    val place: Int,
    val name: String,
    val points: Int,
    val isYou: Boolean = false
)
