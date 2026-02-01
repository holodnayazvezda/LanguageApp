package com.example.languageapp.presentation.components.profile_screen_top_app_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.presentation.screens.profile.ProfileScreenViewModel
import com.example.languageapp.presentation.theme.deepBlue
import com.example.languageapp.presentation.theme.white
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreenTopAppBar(
    profileScreenViewModel: ProfileScreenViewModel,
    viewModel: ProfileScreenTopAppBarViewModel = koinViewModel(),
) {
    val name = viewModel.userFirstName.collectAsState().value
    Column(
        modifier = Modifier.fillMaxWidth().height(230.dp).background(deepBlue).padding(horizontal = 25.dp)
    ) {
        Spacer(Modifier.height(45.dp))
        Image(
            bitmap = profileScreenViewModel.imageToCrop.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(135.dp).clip(CircleShape),
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Your profile, $name",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 22.sp,
            color = white
        )
    }
}