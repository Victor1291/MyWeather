package com.shu.weather_main.tables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.shu.weather_main.R
import com.shu.weather_main.WeatherMainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DataTable(
    viewModel: WeatherMainViewModel,
    /* headerColumn: List<String>,
     infoColumns: Map<String, List<String>>,*/
    modifier: Modifier = Modifier,
) {
    val listWeather by viewModel.weatherAll.collectAsState()
    val heights = remember { mutableStateMapOf<Int, Dp>() }
    val localDensity = LocalDensity.current



    LazyRow(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_smaller)),
        modifier = modifier.padding(
            top = dimensionResource(R.dimen.height),
            bottom = dimensionResource(R.dimen.height),
            start =dimensionResource(R.dimen.padding_small)
        )
    ) {
        stickyHeader {
            Column () {
                listWeather.listCity.forEachIndexed { index, title ->
                    HeaderText(
                        text = title.take(11),
                        modifier = Modifier.onGloballyPositioned { coord ->
                            val height = with(localDensity) { coord.size.height.toDp() }
                            heights[index] = height
                        }.border(2.dp, Color.Red)
                    )
                    Text(
                        text = "",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = modifier,
                        fontSize = 20.sp
                    )
                }
            }
        }
        itemsIndexed(listWeather.tempTable.values.toList()) { colIndex, weather ->
            Column(modifier = Modifier.border(2.dp, Color.Red)) {
                weather.forEachIndexed { index, check ->
                    val height = heights[index] ?: 0.dp
                    Text(
                        text = "",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = modifier,
                        fontSize = 20.sp
                    )
                    if (index == 0) {
                        ColumnTopImage(
                            colIndex = colIndex,
                            content = check,
                            modifier = Modifier.height(height)
                        )
                    } else {
                        CellInfoContent(
                            colIndex = colIndex,
                            content = check,
                            modifier = Modifier.height(height)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun HeaderText(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(2.dp),
        fontSize = 20.sp
    )
}

@Composable
fun ColumnTopImage(
    colIndex: Int,
    content: String,
    modifier: Modifier
) {
    Text(
        text = content,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier,
        fontSize = 20.sp
    )
}

@Composable
fun CellInfoContent(
    colIndex: Int,
    content: String,
    modifier: Modifier
) {
    Text(
        text = content,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier,
        fontSize = 20.sp

    )
}