package com.example.languageapp.presentation.screens.exercises.guess_animal_exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.GameTopAppBar
import com.example.languageapp.presentation.theme.green

@Composable
fun CorrectAnswerScreen(
    navigateToMainScreen: () -> Unit,
    navigateToGuessAnimal: () -> Unit,
    viewModel: GuessAnimalExerciseViewModel
) {
    val animalToGuess = viewModel.animalToGuess.collectAsState().value
    Scaffold(
        topBar = {
            GameTopAppBar(
                navigateBack = navigateToMainScreen,
                title = stringResource(R.string.guess_animal_title),
                background = green
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
            Spacer(Modifier.height(70.dp))
            Image(
                painter = painterResource(R.drawable.hooray),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Spacer(Modifier.height(45.dp))
            Text(
                text = stringResource(R.string.holy_molly),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(42.dp))
            AppButton(
                text = stringResource(R.string.btn_next_exercise),
                onClick = {
                    viewModel.updateAnimal()
                    navigateToGuessAnimal()
                }
            )
        }
    }
}