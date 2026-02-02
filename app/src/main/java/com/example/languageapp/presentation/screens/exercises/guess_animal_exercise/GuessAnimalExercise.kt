package com.example.languageapp.presentation.screens.exercises.guess_animal_exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.AppTextField
import com.example.languageapp.presentation.components.GameTopAppBar
import com.example.languageapp.presentation.theme.deepBlue

@Composable
fun GuessAnimalExercise(
    navigateToMainScreen: () -> Unit,
    navigateToCorrectAnswerScreen: () -> Unit,
    navigateToWrongAnswerScreen: () -> Unit,
    viewModel: GuessAnimalExerciseViewModel
) {
    val animalName = viewModel.animalName.collectAsState().value
    val animalToGuess = viewModel.animalToGuess.collectAsState().value
    Scaffold(
        topBar = {
            GameTopAppBar(
                navigateBack = navigateToMainScreen,
                title = stringResource(R.string.guess_animal_title),
                background = deepBlue
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 25.dp)
        ) {
            Spacer(Modifier.height(17.dp))
            AsyncImage(
                model = animalToGuess.imageLink,
                contentDescription = null,
                modifier = Modifier.size(330.dp).clip(RoundedCornerShape(20.dp))
            )
            Spacer(Modifier.height(17.dp))
            AppTextField(
                name = stringResource(R.string.write_who_is_on_image),
                placeholder = "",
                onValueChange = { viewModel.updateAnimalName(it) },
                value = animalName
            )
            Spacer(Modifier.height(17.dp))
            AppButton(
                text = stringResource(R.string.btn_check),
                onClick = {
                    if (viewModel.isCorrect()) {
                        navigateToCorrectAnswerScreen()
                    } else {
                        navigateToWrongAnswerScreen()
                    }
                }
            )
        }
    }
}