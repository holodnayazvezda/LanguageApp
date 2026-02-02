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
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.GameTopAppBar
import com.example.languageapp.presentation.theme.red

@Composable
fun WrongAnswerScreen(
    navigateToMainScreen: () -> Unit,
    navigateToGuessAnimal: () -> Unit,
    viewModel: GuessAnimalExerciseViewModel
) {
    val animalToGuess = viewModel.animalToGuess.collectAsState().value
    Scaffold(
        topBar = {
            GameTopAppBar(
                navigateBack = navigateToMainScreen,
                title = "Guess the animal",
                background = red
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
                painter = painterResource(R.drawable.sadcat),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Spacer(Modifier.height(40.dp))
            Text(
                text = "Eh? Wrong answer :(",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(3.dp))
            Text(
                text = "That is: ${animalToGuess.name.capitalize(Locale.current)}",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(18.dp))
            AppButton(
                text = "Next",
                onClick = {
                    viewModel.updateAnimal()
                    navigateToGuessAnimal()
                }
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = "Try again",
                onClick = { navigateToGuessAnimal() }
            )
        }
    }
}