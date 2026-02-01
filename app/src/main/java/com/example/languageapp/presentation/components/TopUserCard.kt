package com.example.languageapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.languageapp.common.Constants
import com.example.languageapp.domain.models.TopUsersModel
import com.example.languageapp.presentation.theme.dark
import com.example.languageapp.presentation.theme.lightGrey
import com.example.languageapp.presentation.theme.ultraLightGrey

@Composable
fun TopUserCard(topUsersModel: TopUsersModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(ultraLightGrey),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(13.dp))
        AsyncImage(
            model = topUsersModel.avatarUrl,
            contentDescription = "ava",
            modifier = Modifier
                .width(24.dp)
                .height(36.dp)
        )
        Spacer(Modifier.width(25.dp))
        Text(
            text = topUsersModel.name,
            color = dark,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 17.sp,
            modifier = Modifier.width(170.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.width(3.dp))
        Text(
            text = "${topUsersModel.amountOfPoints} points",
            color = dark,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 17.sp,
        )
        Spacer(Modifier.width(3.dp))

    }
}


@Preview
@Composable
private fun TopUserCardPreview() {
    TopUserCard(Constants.topUsers[0])
}