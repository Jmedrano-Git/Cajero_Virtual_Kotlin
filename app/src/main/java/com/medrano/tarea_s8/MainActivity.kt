package com.medrano.tarea_s8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.medrano.tarea_s8.ui.theme.Tarea_S8Theme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tarea_S8Theme {
            }
        }
    }
}

@Composable
fun CajeroApp() {
    var saldo by remember { mutableStateOf(0.0) }
    val historial = remember { mutableStateListOf<String>() }

    val navController = rememberNavController()

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