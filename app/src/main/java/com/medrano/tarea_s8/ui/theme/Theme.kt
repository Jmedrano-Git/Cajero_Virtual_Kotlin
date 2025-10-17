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
fun Tarea_S8Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}