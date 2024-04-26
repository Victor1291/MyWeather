package com.shu.tables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DataTable(
    headerColumn: List<String>,
    infoColumns: Map<String, List<String>>,
    modifier: Modifier,
) {

    val heights = remember { mutableStateMapOf<Int,Dp>()}
    val localDensity = LocalDensity.current
    LazyRow(modifier = modifier) {
        stickyHeader {
            Column {
                headerColumn.forEachIndexed { index, title ->
                    HeaderText(
                        text = title,
                        modifier = Modifier.onGloballyPositioned {coord ->
                        val height = with(localDensity) {coord.size.height.toDp()}
                            heights[index] = height
                        }
                    )
                }
            }
        }
        itemsIndexed(infoColumns.values.toList()){colIndex,list ->
            Column {
                list.forEachIndexed { index, check ->
                    val height = heights[index] ?: 0.dp
                    if (index == 0) {
                        ColumnTopImage(colIndex = colIndex, content = check, modifier = Modifier.height(height) )
                    } else {
                        CellInfoContent(colIndex = colIndex, content = check, modifier = Modifier.height(height))
                    }
                }
            }
        }
    }
}


@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier
) {

}

@Composable
fun ColumnTopImage(
    colIndex: Int,
    content: String,
    modifier: Modifier = Modifier
) {

}

@Composable
fun CellInfoContent(
    colIndex: Int,
    content: String,
    modifier: Modifier = Modifier
) {

}