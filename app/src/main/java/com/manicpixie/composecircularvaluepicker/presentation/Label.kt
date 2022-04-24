package com.manicpixie.composecircularvaluepicker.presentation

import androidx.compose.foundation.layout.offset
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.manicpixie.composecircularvaluepicker.ui.theme.LightGray
import com.manicpixie.composecircularvaluepicker.ui.theme.PrimaryBlack


@Composable
fun Label(
    text: String,
    offset: IntOffset,
    isActive: Boolean
) {
    Text(
        modifier = Modifier
            .offset {
                offset
            },
        color = if (isActive) PrimaryBlack else LightGray,
        text = text.uppercase(),
        style = MaterialTheme.typography.body1
    )
}