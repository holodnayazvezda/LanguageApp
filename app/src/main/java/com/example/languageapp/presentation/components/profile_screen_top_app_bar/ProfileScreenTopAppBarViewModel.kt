package com.example.languageapp.presentation.components.profile_screen_top_app_bar

import androidx.lifecycle.ViewModel
import com.example.languageapp.data.storage.AppStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileScreenTopAppBarViewModel(
    val appStorage: AppStorage
): ViewModel() {
    private var _userFirstName = MutableStateFlow("")
    val userFirstName = _userFirstName.asStateFlow()

    init {
        _userFirstName.value = appStorage.firstName.toString()
    }
}