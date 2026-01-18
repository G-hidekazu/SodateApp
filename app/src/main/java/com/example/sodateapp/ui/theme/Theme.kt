package com.example.sodateapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = GreenLight,
    secondary = OrangeLight,
    background = OrangeLight.copy(alpha = 0.35f),
    surface = OrangeLight.copy(alpha = 0.2f),
)

private val DarkColors = darkColorScheme(
    primary = GreenDark,
    secondary = OrangeDark,
    background = GreenDark.copy(alpha = 0.3f),
    surface = GreenDark.copy(alpha = 0.2f),
)

@Composable
fun SodateAppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
