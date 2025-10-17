package com.medrano.tarea_s8.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutMeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFE6E1FF), Color(0xFFFDFBFF))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(280.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(50.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Mi Cajero Virtual",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "Versión 1.0",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                )

                Text(
                    text = "Autor:",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "Curso TECSUP – Jetpack Compose",
                    color = Color(0xFF4C3BCF),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
