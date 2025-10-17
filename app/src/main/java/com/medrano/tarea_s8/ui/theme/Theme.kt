package com.medrano.tarea_s8.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PurplePrimary = Color(0xFF4C3BCF)
private val PurpleLight = Color(0xFFE6E1FF)
private val PurpleDark = Color(0xFF3A2BA2)
private val AccentGreen = Color(0xFF00C853)
private val AccentRed = Color(0xFFD50000)

private val AppColorScheme = lightColorScheme(
    primary = PurplePrimary,
    onPrimary = Color.White,
    secondary = PurpleLight,
    onSecondary = Color.Black,
    surface = Color(0xFFF8F6FF),
    onSurface = Color.Black,
    error = AccentRed,
    tertiary = AccentGreen
)

@Composable
fun CajeroVirtualTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography(),
        content = content
    )
}