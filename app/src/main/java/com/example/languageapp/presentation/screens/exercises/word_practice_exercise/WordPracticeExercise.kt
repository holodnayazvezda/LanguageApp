package com.example.languageapp.presentation.screens.exercises.word_practice_exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.GameTopAppBar
import com.example.languageapp.presentation.theme.blue
import com.example.languageapp.presentation.theme.deepBlue
import com.example.languageapp.presentation.theme.green
import com.example.languageapp.presentation.theme.orange
import com.example.languageapp.presentation.theme.ultraLightGrey

@Composable
fun WordPracticeExercise(
    navigateToMainScreen: () -> Unit,
    viewModel: WordPracticeExerciseViewModel
) {
    val word = viewModel.word.collectAsState().value
    val wordsToGuess = viewModel.wordToGuess.collectAsState().value
    val selectedWord = viewModel.selectedWord.collectAsState().value
    val checkResult = viewModel.checkResult.collectAsState().value
    Scaffold(
        topBar = {
            GameTopAppBar(
                navigateBack = navigateToMainScreen,
                title = stringResource(R.string.word_practice_title),
                background = deepBlue
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(35.dp))
            Text(
                text = word.word,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 28.sp
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = word.transcription,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 17.sp
            )
            Spacer(Modifier.height(35.dp))
            repeat(4) { i ->
                val currentText = wordsToGuess[i]
                val buttonBackground = if (checkResult == 0) {
                    if (selectedWord == currentText) {
                        blue
                    } else {
                        ultraLightGrey
                    }
                } else {
                    if (currentText == selectedWord && checkResult == -1) {
                        orange
                    } else if (currentText == word.translation) {
                        green
                    } else {
                        ultraLightGrey
                    }
                }
                AppButton(
                    text = currentText,
                    onClick = {
                        if (checkResult == 0) viewModel.updateSelectedWord(currentText)
                    },
                    background = buttonBackground
                )
                Spacer(Modifier.height(10.dp))
            }
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                AppButton(
                    text = if (checkResult == 0) stringResource(R.string.btn_check) else stringResource(R.string.btn_next_exercise),
                    onClick = {
                        if (checkResult == 0) {
                            viewModel.check()
                        } else {
                            viewModel.updateWord()
                        }
                    }
                )
                Spacer(Modifier.height(15.dp))
            }
        }
    }
}