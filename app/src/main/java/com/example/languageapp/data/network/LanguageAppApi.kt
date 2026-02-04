package com.example.languageapp.data.network

import com.example.languageapp.data.network.model.ExerciseDto
import com.example.languageapp.data.network.model.SignUpDto
import com.example.languageapp.data.network.model.TopUserDto
import com.example.languageapp.data.network.model.UserDto
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface LanguageAppApi {
    @POST("registration")
    suspend fun signUp(@Body body: SignUpDto): Response<Unit>

    @GET("user")
    suspend fun getUser(): Response<UserDto>

    @GET("leaderboard")
    suspend fun getLeaderboard(): Response<List<TopUserDto>>

    @GET("exercises")
    suspend fun getExercises(): Response<List<ExerciseDto>>

    @Multipart
    @POST("user/avatar")
    suspend fun uploadAvatar(@Part image: MultipartBody.Part): Response<Unit>
}