package com.example.languageapp.presentation.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.profile_screen_top_app_bar.ProfileScreenTopAppBar
import com.example.languageapp.presentation.theme.ultraLightGrey

@Composable
fun ProfileScreen(
    navigateToChangeLanguage: () -> Unit,
    navigateToChooseImage: () -> Unit,
    profileScreenViewModel: ProfileScreenViewModel
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        uri?.let {
            val selectedBitmap = profileScreenViewModel.imageUseCase.uriToBitmap( it)
            if (selectedBitmap != null) {
                profileScreenViewModel.imageToCrop = selectedBitmap
                navigateToChooseImage()
            }
        }
    }

    val themePreference by profileScreenViewModel.appStorage.isSystemInDarkThemeFlow.collectAsState()
    var isSystemInDarkTheme = isSystemInDarkTheme()
    if (themePreference != 0) {
        isSystemInDarkTheme = themePreference == 1
    }
    val buttonTextPrefix = if (isSystemInDarkTheme) "Light" else "Dark"

    Scaffold(
        topBar = {
            ProfileScreenTopAppBar(profileScreenViewModel)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 25.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            AppButton(
                text = "Switch to $buttonTextPrefix",
                onClick = {
                    profileScreenViewModel.changeTheme(isSystemInDarkTheme)
                }
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = "Change mother language",
                onClick = navigateToChangeLanguage
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = "Change your image",
                onClick = {
                    launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = "Logout",
                onClick = {},
                background = ultraLightGrey
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}