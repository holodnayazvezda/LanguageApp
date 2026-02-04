package com.example.languageapp.data.network

import com.example.languageapp.data.network.model.SignUpDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LanguageAppApi {
    @POST("registration")
    suspend fun signUp(@Body body: SignUpDto): Response<Unit>
}