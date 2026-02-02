package com.example.languageapp.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.languageapp.R
import com.example.languageapp.presentation.components.ExerciseCard
import com.example.languageapp.presentation.components.TopUserCard
import com.example.languageapp.presentation.components.screen_main_top_app_bar.ScreenMainTopAppBar
import com.example.languageapp.presentation.theme.blue
import com.example.languageapp.presentation.theme.green
import com.example.languageapp.presentation.theme.orange
import com.example.languageapp.presentation.theme.red

@Composable
fun MainScreen(
     viewModel: MainScreenViewModel = viewModel(),
     navigateToProfile: () -> Unit,
     navigateToGuessAnimalExercise: () -> Unit,
     navigateToWordPracticeExercise: () -> Unit,
     navigateToAuditionExercise: () -> Unit,
     navigateToGameExercise: () -> Unit
) {
    val topUsers = viewModel.topUsers.collectAsState().value
    Scaffold(
        topBar = { ScreenMainTopAppBar(
            navigateToProfile = navigateToProfile
        ) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 25.dp),
        ) {
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.top_users),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(4.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(items = topUsers) { topUser ->
                    TopUserCard(topUsersModel = topUser)
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.available_exercises),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
            )
            Spacer(Modifier.height(10.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    ExerciseCard(
                        imageResId = R.drawable.panda,
                        name = stringResource(R.string.exercise_guess_animal),
                        backgroundColor = blue,
                        onClick = navigateToGuessAnimalExercise
                    )
                    ExerciseCard(
                        imageResId = R.drawable.pencil,
                        name = stringResource(R.string.exercise_word_practice),
                        backgroundColor = red,
                        onClick = navigateToWordPracticeExercise
                    )
                }
                Spacer(Modifier.height(17.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    ExerciseCard(
                        imageResId = R.drawable.volume,
                        name = stringResource(R.string.exercise_audition),
                        backgroundColor = orange,
                        onClick = navigateToAuditionExercise
                    )
                    ExerciseCard(
                        imageResId = R.drawable.gamepad,
                        name = stringResource(R.string.exercise_game),
                        backgroundColor = green,
                        navigateToGameExercise
                    )
                }
            }
        }
    }
}