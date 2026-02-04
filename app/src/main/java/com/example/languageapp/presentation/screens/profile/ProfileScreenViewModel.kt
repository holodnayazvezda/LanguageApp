package com.example.languageapp.presentation.screens.profile

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languageapp.R
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.usecase.GetUserUseCase
import com.example.languageapp.domain.usecase.ImageUseCase
import com.example.languageapp.domain.usecase.UploadAvatarUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ProfileScreenViewModel(
    val imageUseCase: ImageUseCase,
    val appStorage: AppStorage,
    context: Context,
    private val getUserUseCase: GetUserUseCase,
    private val uploadAvatarUseCase: UploadAvatarUseCase
): ViewModel() {
    var imageToCrop by mutableStateOf<Bitmap>(BitmapFactory.decodeResource(context.resources, R.drawable.sample_ava))
    private var _userFirstName = MutableStateFlow("")
    val userFirstName = _userFirstName.asStateFlow()
    
    // We can expose the server avatar URL if needed, though local crop updates might be separate
    private var _serverAvatarUrl = MutableStateFlow<String?>(null)
    val serverAvatarUrl = _serverAvatarUrl.asStateFlow()

    init {
        _userFirstName.value = appStorage.firstName.toString()
        viewModelScope.launch {
            getUserUseCase().onSuccess { user ->
                 _userFirstName.value = user.firstName
                 _serverAvatarUrl.value = user.avatarUrl
            }
        }
    }

    fun changeTheme(isSystemInDarkTheme: Boolean) {
        appStorage.isSystemInDarkTheme = if (isSystemInDarkTheme) -1 else 1
    }
    
    fun uploadImage(context: Context, bitmap: Bitmap, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch {
            try {
                // Convert bitmap to file
                val file = File(context.cacheDir, "avatar.jpg")
                val os = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, os)
                os.flush()
                os.close()
                
                uploadAvatarUseCase(file).onSuccess {
                    onSuccess()
                }.onFailure {
                    onError()
                }
            } catch (e: Exception) {
                onError()
            }
        }
    }
}