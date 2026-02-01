package com.example.languageapp.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.example.languageapp.common.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainScreenViewModel(

) : ViewModel() {
    private var _topUsers = MutableStateFlow(Constants.topUsers)
    val topUsers = _topUsers.asStateFlow()

    init {
        _topUsers.value = Constants.topUsers.sortedByDescending { it.amountOfPoints }.take(3)
        topUsers.value.size
    }
}