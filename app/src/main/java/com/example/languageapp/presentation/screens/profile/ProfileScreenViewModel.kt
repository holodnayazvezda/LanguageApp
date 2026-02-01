package com.example.languageapp.presentation.screens.profile

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.languageapp.R
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.usecase.ImageUseCase

class ProfileScreenViewModel(
    val imageUseCase: ImageUseCase,
    val appStorage: AppStorage,
    context: Context
): ViewModel() {
    var imageToCrop by mutableStateOf<Bitmap>(BitmapFactory.decodeResource(context.resources, R.drawable.sample_ava))

    fun changeTheme(isSystemInDarkTheme: Boolean) {
        appStorage.isSystemInDarkTheme = if (isSystemInDarkTheme) -1 else 1
    }
}