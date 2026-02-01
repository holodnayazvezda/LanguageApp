package com.example.languageapp.presentation.components.screen_main_top_app_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.languageapp.R
import com.example.languageapp.presentation.theme.deepBlue
import com.example.languageapp.presentation.theme.greyDark
import com.example.languageapp.presentation.theme.lightGrey
import com.example.languageapp.presentation.theme.white
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScreenMainTopAppBar(
    viewModel: ScreenMainTopAppBarViewModel = koinViewModel(),
    navigateToProfile: () -> Unit,
) {
    val name = viewModel.name.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(deepBlue)
            .height(175.dp)
            .padding(horizontal = 25.dp),
    ) {
        Spacer(Modifier.height(44.dp))
        AsyncImage(
            model = "https://gitverse.ru/sc/avatars/8794a82f5eec44538caf3ffc74ce9943586d17ecc6411b2460f6a6919e061f22",
            contentDescription = "ava",
            modifier = Modifier.size(54.dp).clip(CircleShape).clickable {
                navigateToProfile()
            }
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = stringResource(R.string.hello_user, name.value ?: ""),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 22.sp,
            color = white
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = stringResource(R.string.ready_for_learning),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 17.sp,
            color = lightGrey
        )
    }
}