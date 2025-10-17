package com.medrano.tarea_s8.Views

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(saldo: Double, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(Icons.Filled.AccountCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(60.dp)
                )
                Text("Saldo Actual", style = MaterialTheme.typography.titleLarge)
                Text("S/ %.2f".format(saldo), style = MaterialTheme.typography.headlineLarge)
            }
        }

        Spacer(Modifier.height(25.dp))

        Button(onClick = { navController.navigate("operaciones") }, shape = MaterialTheme.shapes.extraLarge) {
            Text("Retirar dinero")
        }
        Spacer(Modifier.height(10.dp))
        Button(onClick = { navController.navigate("operaciones") }, shape = MaterialTheme.shapes.extraLarge) {
            Text("Depositar dinero")
        }
    }
}
