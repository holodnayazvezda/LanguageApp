package com.example.languageapp.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languageapp.common.Constants
import com.example.languageapp.domain.models.ExerciseModel
import com.example.languageapp.domain.models.TopUsersModel
import com.example.languageapp.domain.models.UserModel
import com.example.languageapp.domain.usecase.GetExercisesUseCase
import com.example.languageapp.domain.usecase.GetLeaderboardUseCase
import com.example.languageapp.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getLeaderboardUseCase: GetLeaderboardUseCase,
    private val getExercisesUseCase: GetExercisesUseCase
) : ViewModel() {
    private var _topUsers = MutableStateFlow<List<TopUsersModel>>(emptyList())
    val topUsers = _topUsers.asStateFlow()

    private var _exercises = MutableStateFlow<List<ExerciseModel>>(emptyList())
    val exercises = _exercises.asStateFlow()
    
    // Assuming we might want to expose user info to the screen or TopAppBar via shared flow or storage
    // For now, let's just fetch it.
    private var _user = MutableStateFlow<UserModel?>(null)
    val user = _user.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            getUserUseCase().onSuccess { userModel ->
                _user.value = userModel
            }
            getLeaderboardUseCase().onSuccess { list ->
                _topUsers.value = list.take(3) // Ensure only top 3 as per requirements
            }
            getExercisesUseCase().onSuccess { list ->
                _exercises.value = list
            }
        }
    }
}