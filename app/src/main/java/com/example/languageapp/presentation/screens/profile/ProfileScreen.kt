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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.ProfileScreenTopAppBar
import com.example.languageapp.presentation.theme.ultraLightGrey

@Composable
fun ProfileScreen(
    navigateToChangeLanguage: () -> Unit,
    navigateToChooseImage: () -> Unit,
    viewModel: ProfileScreenViewModel
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        uri?.let {
            val selectedBitmap = viewModel.imageUseCase.uriToBitmap( it)
            if (selectedBitmap != null) {
                viewModel.imageToCrop = selectedBitmap
                navigateToChooseImage()
            }
        }
    }

    val themePreference by viewModel.appStorage.isSystemInDarkThemeFlow.collectAsState()
    var isSystemInDarkTheme = isSystemInDarkTheme()
    if (themePreference != 0) {
        isSystemInDarkTheme = themePreference == 1
    }
    val buttonText = if (isSystemInDarkTheme) stringResource(R.string.switch_to_light) else stringResource(R.string.switch_to_dark)
    // PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
    Scaffold(
        topBar = {
            ProfileScreenTopAppBar(viewModel)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(horizontal = 25.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            AppButton(
                text = buttonText,
                onClick = {
                    viewModel.changeTheme(isSystemInDarkTheme)
                }
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = stringResource(R.string.change_mother_language),
                onClick = navigateToChangeLanguage
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = stringResource(R.string.change_your_image),
                onClick = {
                    launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }
            )
            Spacer(Modifier.height(10.dp))
            AppButton(
                text = stringResource(R.string.logout),
                onClick = {},
                background = ultraLightGrey
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}