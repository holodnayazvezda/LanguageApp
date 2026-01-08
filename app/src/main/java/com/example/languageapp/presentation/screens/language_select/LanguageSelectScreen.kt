package com.example.languageapp.presentation.screens.language_select

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.common.Constants
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.LanguageCard
import com.example.languageapp.presentation.components.ScreenDefaultTopAppBor

@Composable
fun LanguageSelectScreen() {
    var selectedLanguage by remember { mutableStateOf(Constants.languageCodes[0].shortName) }
    Scaffold(
        topBar = {
            ScreenDefaultTopAppBor(
                title = "Language select",
                navigateToPreviousScreen = null
            )
        },
        bottomBar = {
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp)) {
                AppButton(
                    text = "Choose",
                    onClick = {}
                )
                Spacer(Modifier.height(30.dp))
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize().background(
                MaterialTheme.colorScheme.background
            ).padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.padding(8.dp))
            Text(
                text = "What is your Mother language?",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 22.sp
            )
            Spacer(Modifier.height(15.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(Constants.languageCodes) { card ->
                    LanguageCard(
                        card = card,
                        isSelected = selectedLanguage == card.shortName,
                        onClick = {
                            selectedLanguage = card.shortName
                        }
                    )
                }
            }
        }
    }
}