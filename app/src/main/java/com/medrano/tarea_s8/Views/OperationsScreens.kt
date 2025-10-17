package com.medrano.tarea_s8.Views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun OperationsScreen(
    saldo: Double,
    actualizarSaldo: (Double) -> Unit,
    historial: MutableList<String>
) {
    var montoRetiro by remember { mutableStateOf("") }
    var montoDeposito by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    val formatoFecha = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Retiros
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    "Retiros",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF1C1C1C)
                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    value = montoRetiro,
                    onValueChange = { montoRetiro = it },
                    label = { Text("Monto a retirar") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(15.dp))

                Button(
                    onClick = {
                        val valor = montoRetiro.toDoubleOrNull() ?: 0.0
                        if (valor > 0) {
                            if (valor <= saldo) {
                                actualizarSaldo(saldo - valor)
                                val texto = "[${formatoFecha.format(Date())}] Retiro: S/ %.2f".format(valor)
                                historial.add(0, texto)
                                mensaje = "Retiro realizado correctamente."
                                montoRetiro = ""
                            } else {
                                mensaje = "Error: Saldo insuficiente para retirar."
                            }
                        } else {
                            mensaje = "Error: Ingrese un monto válido para retirar."
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text("Retirar", color = Color.White)
                }
            }
        }

        // DEPÓSITOS
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    "Depósitos",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF1C1C1C)
                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    value = montoDeposito,
                    onValueChange = { montoDeposito = it },
                    label = { Text("Monto a depositar") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(15.dp))

                Button(
                    onClick = {
                        val valor = montoDeposito.toDoubleOrNull() ?: 0.0
                        if (valor > 0) {
                            actualizarSaldo(saldo + valor)
                            val texto = "[${formatoFecha.format(Date())}] Depósito: S/ %.2f".format(valor)
                            historial.add(0, texto)
                            mensaje = "Depósito realizado correctamente."
                            montoDeposito = ""
                        } else {
                            mensaje = "Error: Ingrese un monto válido para depositar."
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text("Depositar", color = Color.White)
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // Saldo y Mensaje
        Text(
            "Saldo actual: S/ %.2f".format(saldo),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1A237E)
        )

        Spacer(Modifier.height(10.dp))

        if (mensaje.isNotEmpty()) {
            Text(
                mensaje,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
