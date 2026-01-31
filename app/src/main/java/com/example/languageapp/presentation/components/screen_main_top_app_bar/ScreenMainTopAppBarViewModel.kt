package com.example.languageapp.presentation.components.screen_main_top_app_bar

import androidx.lifecycle.ViewModel
import com.example.languageapp.data.storage.AppStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScreenMainTopAppBarViewModel(
    val appStorage: AppStorage
) : ViewModel() {
    private var _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    init {
        _name.value = appStorage.firstName ?: "Emil"
    }
}