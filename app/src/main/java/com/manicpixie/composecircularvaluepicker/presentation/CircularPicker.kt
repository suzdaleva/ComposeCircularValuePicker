package com.manicpixie.composecircularvaluepicker.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.manicpixie.composecircularvaluepicker.ui.theme.ExtraLightGray
import com.manicpixie.composecircularvaluepicker.ui.theme.PrimaryBlack
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
fun CircularPicker(
    sessionMoods: List<String>,
    setSessionMood: (String) -> Unit
) {
    var radius by remember {
        mutableStateOf(0f)
    }

    var shapeCenter by remember {
        mutableStateOf(Offset.Zero)
    }


    var targetValue by remember {
        mutableStateOf(-120.0)
    }
    val angle by animateFloatAsState(
        targetValue = targetValue.toFloat(),
        animationSpec = tween(durationMillis = 700)
    )

    var currentMood by remember {
        mutableStateOf(1)
    }

    val density = LocalDensity.current.density

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)

    ) {
        shapeCenter = center.copy(x = center.x + size.width / 2, y = size.height / 1.75f)
        radius = size.minDimension / 1.8f
        drawCircle(
            center = shapeCenter,
            color = ExtraLightGray,
            style = Stroke(7f),
            radius = radius
        )
        drawArc(
            color = PrimaryBlack,
            startAngle = 0f,
            topLeft = Offset(size.width - radius, shapeCenter.y - radius),
            size = Size(radius * 2, radius * 2),
            sweepAngle = max(angle, -240f),
            useCenter = false,
            style = Stroke(9f, cap = StrokeCap.Round)
        )

    }

    val firstOffset = calculateCenter(shapeCenter, -120.0, radius)
    val secondOffset = calculateCenter(shapeCenter, -150.0, radius)
    val thirdOffset = calculateCenter(shapeCenter, -180.0, radius)
    val fourthOffset = calculateCenter(shapeCenter, -210.0, radius)
    val fifthOffset = calculateCenter(shapeCenter, -240.0, radius)

    Label(
        isActive = currentMood == 1,
        text = sessionMoods[0],
        offset = (firstOffset.copy(
            x = firstOffset.x - (250 * density / 2.75).roundToInt(),
            y = firstOffset.y + (20 * density / 2.75).roundToInt()
        ))
    )
    Label(
        isActive = currentMood == 2,
        text = sessionMoods[1],
        offset = (secondOffset.copy(
            x = secondOffset.x - (250 * density / 2.75).roundToInt(),
            y = secondOffset.y + (35 * density / 2.75).roundToInt()
        ))
    )
    Label(
        isActive = currentMood == 3,
        text = sessionMoods[2],
        offset = (thirdOffset.copy(
            x = thirdOffset.x - (200 * density / 2.75).roundToInt(),
            y = thirdOffset.y + (20 * density / 2.75).roundToInt()
        ))
    )
    Label(
        isActive = currentMood == 4,
        text = sessionMoods[3],
        offset = (fourthOffset.copy(
            x = fourthOffset.x - (200 * density / 2.75).roundToInt(),
            y = fourthOffset.y + (20 * density / 2.75).roundToInt()
        ))
    )
    Label(
        isActive = currentMood == 5,
        text = sessionMoods[4],
        offset = (fifthOffset.copy(
            x = fifthOffset.x - (220 * density / 2.75).roundToInt(),
            y = fifthOffset.y + (20 * density / 2.75).roundToInt()
        ))
    )

    RoundButton(size = 50.dp, isActive = (currentMood == 1), offset = firstOffset, onClick = {
        targetValue = -120.0
        currentMood = 1
        setSessionMood(sessionMoods[0])
    })
    RoundButton(size = 50.dp, isActive = (currentMood == 2), offset = secondOffset, onClick = {
        targetValue = -150.0
        currentMood = 2
        setSessionMood(sessionMoods[1])
    })
    RoundButton(size = 50.dp, isActive = (currentMood == 3), offset = thirdOffset, onClick = {
        targetValue = -180.0
        currentMood = 3
        setSessionMood(sessionMoods[2])
    })
    RoundButton(size = 50.dp, isActive = (currentMood == 4), offset = fourthOffset, onClick = {
        targetValue = -210.0
        currentMood = 4
        setSessionMood(sessionMoods[3])
    })
    RoundButton(size = 50.dp, isActive = (currentMood == 5), offset = fifthOffset, onClick = {
        targetValue = -240.0
        currentMood = 5
        setSessionMood(sessionMoods[4])
    })
}

private fun calculateCenter(shapeCenter: Offset, angle: Double, radius: Float): IntOffset {
    val x = (shapeCenter.x + cos(Math.toRadians(angle)) * radius).toFloat().roundToInt()
    val y = (shapeCenter.y + sin(Math.toRadians(angle)) * radius).toFloat().roundToInt()
    return IntOffset(x, y)
}