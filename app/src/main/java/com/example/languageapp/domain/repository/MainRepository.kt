package com.example.languageapp.domain.repository

import com.example.languageapp.domain.models.ExerciseModel
import com.example.languageapp.domain.models.TopUsersModel
import com.example.languageapp.domain.models.UserModel
import java.io.File

interface MainRepository {
    suspend fun getUser(): Result<UserModel>
    suspend fun getLeaderboard(): Result<List<TopUsersModel>>
    suspend fun getExercises(): Result<List<ExerciseModel>>
    suspend fun uploadAvatar(file: File): Result<Unit>
}