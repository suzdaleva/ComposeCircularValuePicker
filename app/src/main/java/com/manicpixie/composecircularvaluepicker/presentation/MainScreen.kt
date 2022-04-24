package com.manicpixie.composecircularvaluepicker.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manicpixie.composecircularvaluepicker.ui.theme.PrimaryBlack
import com.manicpixie.composecircularvaluepicker.ui.theme.White

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
            .padding(top = 60.dp)
    ) {
        var currentSessionMood by remember {
            mutableStateOf(Constants.sessionMoods[0])
        }
        CircularPicker(sessionMoods = Constants.sessionMoods, setSessionMood = {
            currentSessionMood = it
        })
        Text(
            text = currentSessionMood.uppercase(),
            style = MaterialTheme.typography.body1,
            fontSize = 24.sp,
            color = PrimaryBlack,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp)
        )
    }
}