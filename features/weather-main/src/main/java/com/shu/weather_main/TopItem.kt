package com.shu.weather_main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopItem(
    header: String,
    rightIconImageVector: ImageVector? = null,
    leftIconImageVector: ImageVector? = null,
    onLeftIconClick: (() -> Unit)? = null,
    onRightIconClick: (() -> Unit)? = null,
    isLoading: Boolean = false
) {
    Column {
        Row(
            modifier = Modifier
                .height(dimensionResource(R.dimen.height))
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.padding_small), bottom = dimensionResource(R.dimen.padding_smaller)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .padding(start = dimensionResource(R.dimen.padding_large), end = dimensionResource(R.dimen.padding_largest))
                    .size(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        onLeftIconClick?.invoke()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                leftIconImageVector?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = "back",
                        modifier = Modifier
                    )
                }
            }

            Text(
                text = header,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            )

            Column(
                Modifier
                    .padding(start = dimensionResource(R.dimen.padding_largest), end = dimensionResource(R.dimen.padding_large))
                    .size(dimensionResource(R.dimen.size_icon))
                    .clip(CircleShape)
                    .clickable {
                        onRightIconClick?.invoke()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                rightIconImageVector?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = "right",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    TopItem(
        header = "Moscow",
        leftIconImageVector = Icons.Rounded.Search,
        rightIconImageVector = Icons.Rounded.Settings,
        onLeftIconClick = {},
        onRightIconClick = {}
    )
}
