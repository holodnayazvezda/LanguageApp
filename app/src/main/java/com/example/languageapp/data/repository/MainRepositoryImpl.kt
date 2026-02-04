package com.example.languageapp.data.repository

import com.example.languageapp.data.network.LanguageAppApi
import com.example.languageapp.domain.models.ExerciseModel
import com.example.languageapp.domain.models.TopUsersModel
import com.example.languageapp.domain.models.UserModel
import com.example.languageapp.domain.repository.MainRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class MainRepositoryImpl(
    private val api: LanguageAppApi
) : MainRepository {
    override suspend fun getUser(): Result<UserModel> {
        return try {
            val response = api.getUser()
            if (response.isSuccessful && response.body() != null) {
                val dto = response.body()!!
                Result.success(
                    UserModel(
                        id = dto.id,
                        firstName = dto.firstName,
                        lastName = dto.lastName,
                        email = dto.email,
                        avatarUrl = dto.avatarUrl
                    )
                )
            } else {
                Result.failure(Exception("Failed to get user: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getLeaderboard(): Result<List<TopUsersModel>> {
        return try {
            val response = api.getLeaderboard()
            if (response.isSuccessful && response.body() != null) {
                val list = response.body()!!.map { dto ->
                    TopUsersModel(
                        avatarUrl = dto.avatarUrl,
                        name = dto.name,
                        amountOfPoints = dto.amountOfPoints
                    )
                }
                Result.success(list)
            } else {
                Result.failure(Exception("Failed to get leaderboard: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getExercises(): Result<List<ExerciseModel>> {
        return try {
            val response = api.getExercises()
            if (response.isSuccessful && response.body() != null) {
                val list = response.body()!!.map { dto ->
                    ExerciseModel(
                        id = dto.id,
                        name = dto.name,
                        iconUrl = dto.iconUrl,
                        type = dto.type
                    )
                }
                Result.success(list)
            } else {
                Result.failure(Exception("Failed to get exercises: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun uploadAvatar(file: File): Result<Unit> {
        return try {
            val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
            val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
            val response = api.uploadAvatar(body)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Failed to upload avatar: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}