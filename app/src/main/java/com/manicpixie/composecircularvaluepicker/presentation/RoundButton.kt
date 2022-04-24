package com.manicpixie.composecircularvaluepicker.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.manicpixie.composecircularvaluepicker.ui.theme.PrimaryBlack
import com.manicpixie.composecircularvaluepicker.ui.theme.White

@Composable
fun RoundButton(
    size: Dp,
    isActive: Boolean,
    offset: IntOffset,
    onClick: () -> Unit
) {
    val color by animateColorAsState(
        targetValue = if (isActive) PrimaryBlack else White,
        animationSpec = tween(durationMillis = 700)
    )

    Box(modifier = Modifier
        .offset {
            (offset)
        }
        .drawColoredShadow(
            alpha = 0.1f,
            shadowRadius = 5.dp,
            color = PrimaryBlack,
            borderRadius = 23.dp
        )
        .size(size)
        .clip(CircleShape)
        .noRippleClickable { onClick() }
        .background(color)
    )
}