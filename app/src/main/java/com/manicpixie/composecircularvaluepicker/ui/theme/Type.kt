package com.manicpixie.composecircularvaluepicker.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.manicpixie.composecircularvaluepicker.R


val urbanistFont = FontFamily(
    listOf(
        Font(R.font.urbanist_medium, FontWeight.Medium),
    )
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = urbanistFont,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    )
)