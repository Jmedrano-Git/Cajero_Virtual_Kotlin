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

    Scaffold (
        topBar = {
            TopAppBar(title = {Text("Mi Cajero Virtual")})
        },
        bottomBar = {
            NavigationBar {
                //Item de Navegación de Home
                NavigationBarItem(
                    selected = false,
                    onClick = {navController.navigate("home")},
                    label = {Text("Inicio")},
                    icon = {}
                )

                //Item de Navegación de Operaciones
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("operaciones") },
                    label = { Text("Operaciones") },
                    icon = {}
                )

                //Item de navegación de Historial
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("historial") },
                    label = { Text("Historial") },
                    icon = {}
                )

                //Item de navegación de Acerca De
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("about") },
                    label = { Text("Acerca de") },
                    icon = {}
                )
            }
        }
    ){  }
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}