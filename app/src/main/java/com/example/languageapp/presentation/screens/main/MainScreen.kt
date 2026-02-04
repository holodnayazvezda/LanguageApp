package com.example.languageapp.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.languageapp.R
import com.example.languageapp.presentation.components.ExerciseCard
import com.example.languageapp.presentation.components.TopUserCard
import com.example.languageapp.presentation.components.screen_main_top_app_bar.ScreenMainTopAppBar
import com.example.languageapp.presentation.theme.blue
import com.example.languageapp.presentation.theme.green
import com.example.languageapp.presentation.theme.orange
import com.example.languageapp.presentation.theme.red
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
     viewModel: MainScreenViewModel = koinViewModel(),
     navigateToProfile: () -> Unit,
     navigateToGuessAnimalExercise: () -> Unit,
     navigateToWordPracticeExercise: () -> Unit,
     navigateToAuditionExercise: () -> Unit,
     navigateToGameExercise: () -> Unit
) {
    val topUsers = viewModel.topUsers.collectAsState().value
    val exercises = viewModel.exercises.collectAsState().value
    
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
                modifier = Modifier.fillMaxWidth().height(200.dp), // Limit height or use weight
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
            
            // Dynamic Grid for Exercises
            // Assuming exercises list comes from server. 
            // Mapping server "type" or "name" to navigation action and colors/icons.
            // For simplicity and matching requirements "Tile of exercise options", we can map them.
            // If the server returns specifically those 4 exercises:
            
            // A simple grid implementation manually for 2 columns
            Column(Modifier.fillMaxWidth()) {
                val rows = exercises.chunked(2)
                rows.forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        rowItems.forEach { exercise ->
                            // Map exercise type/name to resource and color
                            // This logic might be better in VM but putting here for UI mapping
                            val (icon, color, action) = when(exercise.type) { // or exercise.name
                                "GUESS_ANIMAL" -> Triple(R.drawable.panda, blue, navigateToGuessAnimalExercise)
                                "WORD_PRACTICE" -> Triple(R.drawable.pencil, red, navigateToWordPracticeExercise)
                                "AUDITION" -> Triple(R.drawable.volume, orange, navigateToAuditionExercise)
                                "GAME" -> Triple(R.drawable.gamepad, green, navigateToGameExercise)
                                else -> Triple(R.drawable.panda, blue, {}) // Fallback
                            }
                            
                            ExerciseCard(
                                imageResId = icon,
                                name = exercise.name, // Use server name
                                backgroundColor = color,
                                onClick = action
                            )
                        }
                    }
                    Spacer(Modifier.height(17.dp))
                }
            }
        }
    }
}