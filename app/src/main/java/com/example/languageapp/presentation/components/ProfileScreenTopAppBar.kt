package com.example.languageapp.presentation.components

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.languageapp.R
import com.example.languageapp.presentation.components.profile_screen_top_app_bar.ProfileScreenTopAppBarViewModel
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
    val avatarUrl = viewModel.avatarUrl.collectAsState().value

    Column(
        modifier = Modifier.fillMaxWidth().height(230.dp).background(deepBlue).padding(horizontal = 25.dp)
    ) {
        Spacer(Modifier.height(45.dp))
        // Logic: If user has selected a new image to crop (which seems to be stored in profileScreenViewModel.imageToCrop),
        // we might want to show that? Or the server one? 
        // Based on ProfileScreen logic, 'imageToCrop' is set when picking from gallery. 
        // But the requirement says "Profile page should display current user avatar". 
        // And then "After selecting image... open resize photo".
        // So here we should probably display the server avatar, unless we just updated it.
        // However, the original code used `imageToCrop.asImageBitmap()`.
        // Let's stick to server avatar for the main profile view, 
        // assuming imageToCrop is only for the crop screen.
        
        AsyncImage(
            model = avatarUrl ?: R.drawable.sample_ava,
            contentDescription = null,
            modifier = Modifier.size(135.dp).clip(CircleShape),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.sample_ava),
            placeholder = painterResource(R.drawable.sample_ava)
        )

        Spacer(Modifier.height(5.dp))
        Text(
            text = stringResource(R.string.your_profile, name ?: ""),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 22.sp,
            color = white
        )
    }
}