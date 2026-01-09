package com.example.languageapp.presentation.screens.language_select

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import com.example.languageapp.common.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LanguageSelectViewModel(
    val context: Context,
): ViewModel() {
    private var _selectedLanguage = MutableStateFlow(Constants.languageCodes[0].shortName)
    var selectedLanguage = _selectedLanguage.asStateFlow()

    fun setSelectedLanguage(language: String) {
        if (language == "en" || language == "ru") {
            _selectedLanguage.value = language
        }
    }

    fun setSelectedLanguageInAndroid() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val localeManager = context.getSystemService(LocaleManager::class.java)
            localeManager.applicationLocales =
                LocaleList.forLanguageTags(selectedLanguage.value)
        } else {
           // TODO: UNREAL
        }
    }
}
