package com.example.languageapp.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.theme.deepBlue
import com.example.languageapp.presentation.theme.ultraLightGrey
import com.example.languageapp.presentation.theme.white
import com.image.cropview.CropType
import com.image.cropview.EdgeType
import com.image.cropview.ImageCrop

@Composable
fun ChooseImageScreen(
    profileScreenViewModel: ProfileScreenViewModel,
    navigateBack: () -> Unit
) {
    val imageCrop = remember(profileScreenViewModel.imageToCrop) {
        ImageCrop(profileScreenViewModel.imageToCrop)
    }
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(104.dp)
                    .background(deepBlue)
                    .padding(horizontal = 25.dp)
            ) {
                Spacer(Modifier.height(60.dp))
                Text(
                    text = "Your photo is gorgeous!",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 22.sp,
                    color = white
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            imageCrop.ImageCropView(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.9f),
                guideLineColor = ultraLightGrey,
                guideLineWidth = 2.dp,
                edgeCircleSize = 5.dp,
                showGuideLines = true,
                cropType = CropType.PROFILE_CIRCLE,
                edgeType = EdgeType.SQUARE
            )
            Spacer(Modifier.height(20.dp))
            Column(Modifier.fillMaxWidth().weight(0.1f).padding(horizontal = 25.dp)) {
                AppButton(
                    text = "Use that image",
                    onClick = {
                        profileScreenViewModel.imageToCrop = imageCrop.onCrop()
                        navigateBack()
                    }
                )
            }
            Spacer(Modifier.height(10.dp))
        }
    }
}