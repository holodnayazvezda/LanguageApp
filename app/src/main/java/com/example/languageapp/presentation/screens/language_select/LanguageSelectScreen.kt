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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.common.Constants
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.LanguageCard
import com.example.languageapp.presentation.components.ScreenDefaultTopAppBor
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun LanguageSelectScreen(
    navigateToNextScreen: () -> Unit,
    viewModel: LanguageSelectViewModel = koinViewModel()
) {
    val selectedLanguage = viewModel.selectedLanguage.collectAsState()
    Scaffold(
        topBar = {
            ScreenDefaultTopAppBor(
                title = stringResource(R.string.language_select_header),
                navigateToPreviousScreen = null
            )
        },
        bottomBar = {
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp)) {
                AppButton(
                    text = stringResource(R.string.btn_choose),
                    onClick = {
                        viewModel.setSelectedLanguageInAndroid()
                        navigateToNextScreen()
                    }
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
                text = stringResource(R.string.mother_language_question),
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
                        isSelected = selectedLanguage.value == card.shortName,
                        onClick = {
                            viewModel.setSelectedLanguage(card.shortName);
                        }
                    )
                }
            }
        }
    }
}