package com.kisisel.tarayici.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val OledBlack = Color(0xFF000000)
val DarkSurface = Color(0xFF121212)
val CardDark = Color(0xFF1E1E1E)
val NeonPurple = Color(0xFFBB86FC)
val TextGray = Color(0xFFAAAAAA)

private val DarkColorScheme = darkColorScheme(
    primary = NeonPurple,
    background = OledBlack,
    surface = DarkSurface,
    onPrimary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun KisiselTarayiciTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
