package com.example.languageapp.presentation.widget

import com.example.languageapp.common.Constants
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.models.LeaderBoardModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LeaderboardWidgetViewModel(
    val appStorage: AppStorage
) {
    private var _leaders = MutableStateFlow(listOf<LeaderBoardModel>())
    val leaders = _leaders.asStateFlow()

    init {
        _leaders.value = Constants.dataForWidget
    }
}