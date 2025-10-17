package com.medrano.tarea_s8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.medrano.tarea_s8.Views.*
import com.medrano.tarea_s8.ui.theme.CajeroVirtualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CajeroVirtualTheme {
                MiCajeroVirtualApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiCajeroVirtualApp() {
    var saldo by remember { mutableStateOf(0.0) }
    val historial = remember { mutableStateListOf<String>() }
    val navController = rememberNavController()
    var mostrarMenu by remember { mutableStateOf(false) }  // control simple del menú

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Cajero Virtual") },
                actions = {
                    IconButton(onClick = { mostrarMenu = !mostrarMenu }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menú")
                    }

                    if (mostrarMenu) {
                        DropdownMenu(
                            expanded = true,
                            onDismissRequest = { mostrarMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Inicio") },
                                onClick = {
                                    navController.navigate("inicio")
                                    mostrarMenu = false
                                },
                                leadingIcon = { Icon(Icons.Default.Home, contentDescription = null) }
                            )
                            DropdownMenuItem(
                                text = { Text("Operaciones") },
                                onClick = {
                                    navController.navigate("operaciones")
                                    mostrarMenu = false
                                },
                                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) }
                            )
                            DropdownMenuItem(
                                text = { Text("Historial") },
                                onClick = {
                                    navController.navigate("historial")
                                    mostrarMenu = false
                                },
                                leadingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) }
                            )
                            DropdownMenuItem(
                                text = { Text("Acerca de") },
                                onClick = {
                                    navController.navigate("acerca")
                                    mostrarMenu = false
                                },
                                leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) }
                            )
                        }
                    }
                }
            )
        }
    ) {
        Box {
            NavHost(navController, startDestination = "inicio") {
                composable("inicio") { HomeScreen(saldo, navController) }
                composable("operaciones") { OperationsScreen(saldo, { saldo = it }, historial) }
                composable("historial") { HistorialScreen(historial) }
                composable("acerca") { AboutMeScreen() }
            }
        }
    ){  }
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}