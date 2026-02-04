package com.example.languageapp.presentation.components.profile_screen_top_app_bar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileScreenTopAppBarViewModel(
    private val appStorage: AppStorage,
    private val getUserUseCase: GetUserUseCase
): ViewModel() {
    private var _userFirstName = MutableStateFlow(appStorage.firstName)
    val userFirstName = _userFirstName.asStateFlow()
    
    private var _avatarUrl = MutableStateFlow<String?>(null)
    val avatarUrl = _avatarUrl.asStateFlow()

    init {
        viewModelScope.launch {
            getUserUseCase().onSuccess { user ->
                _userFirstName.value = user.firstName
                _avatarUrl.value = user.avatarUrl
                appStorage.firstName = user.firstName
            }
        }
    }
}