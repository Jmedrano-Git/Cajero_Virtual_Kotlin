package com.medrano.tarea_s8.Views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HistorialScreen(historial: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "📜 Historial de Transacciones",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Lista de transacciones
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(historial) { transaccion ->
                TransaccionItem(transaccion)
            }
        }
    }
}

@Composable
fun TransaccionItem(texto: String) {
    // Identificamos si es depósito o retiro
    val esDeposito = texto.contains("Depósito")
    val colorMonto = if (esDeposito) Color(0xFF00C853) else Color(0xFFD50000)
    val icono = if (esDeposito) Icons.Filled.Add else Icons.Filled.Close
    val tipo = if (esDeposito) "Depósito" else "Retiro"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F6FF))
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icono, contentDescription = null, tint = colorMonto)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    tipo,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                texto,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                if (esDeposito) "+${texto.substringAfter("S/")}" else "-${texto.substringAfter("S/")}",
                color = colorMonto,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
