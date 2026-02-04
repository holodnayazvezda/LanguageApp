package com.example.languageapp.presentation.components.screen_main_top_app_bar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScreenMainTopAppBarViewModel(
    private val appStorage: AppStorage,
    private val getUserUseCase: GetUserUseCase
): ViewModel() {
    private var _name = MutableStateFlow(appStorage.firstName)
    val name = _name.asStateFlow()
    
    private var _avatarUrl = MutableStateFlow<String?>(null)
    val avatarUrl = _avatarUrl.asStateFlow()

    init {
        viewModelScope.launch {
            getUserUseCase().onSuccess { user ->
                _name.value = user.firstName
                _avatarUrl.value = user.avatarUrl
                // Update local storage if needed, or rely on network source of truth
                appStorage.firstName = user.firstName
            }
        }
    }
}