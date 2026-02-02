package com.example.languageapp.presentation.screens.exercises.audition_exercise

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.AppTextField
import com.example.languageapp.presentation.components.GameTopAppBar
import com.example.languageapp.presentation.theme.deepBlue
import com.example.languageapp.presentation.theme.green
import okhttp3.internal.http2.Header

@Composable
fun AuditionExercise(
    viewModel: AuditionExerciseViewModel,
    navigateToMainScreen: () -> Unit,
) {
    val word = viewModel.word.collectAsState().value
    val isRecording = viewModel.isRecording.collectAsState().value
    val pronouncedWord = viewModel.pronouncedWord.collectAsState().value
    val scale by rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        )
    )

    Scaffold(
        topBar = {
            GameTopAppBar(
                navigateBack = navigateToMainScreen,
                title = stringResource(R.string.listening_title),
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
                fontSize = 22.sp
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = word.transcription,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 15.sp
            )
            Spacer(Modifier.height(70.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.audition_instructions),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 22.sp
                )
            }
            Spacer(Modifier.height(12.dp))
            if (isRecording == 0) {
                AppButton(
                    text = stringResource(R.string.check_my_speech),
                    onClick = {
                        viewModel.startWordRecording()
                    },
                )
            } else if (isRecording == 1) {
                AppTextField(
                    name = stringResource(R.string.your_result),
                    value = pronouncedWord,
                    placeholder = "",
                    onValueChange = {}
                )
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .size(160.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(green),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.micro),
                            contentDescription = "Microphone",
                            modifier = Modifier.width(80.dp).scale(scale)
                        )
                    }
                    Spacer(Modifier.height(50.dp))
                }
            } else {
                AppTextField(
                    name = stringResource(R.string.your_result),
                    value = pronouncedWord,
                    placeholder = "",
                    onValueChange = {}
                )
                Spacer(Modifier.height(12.dp))
                AppButton(
                    text = stringResource(R.string.yay_go_next),
                    onClick = {
                        viewModel.updateWord()
                    }
                )
            }
        }
    }
}