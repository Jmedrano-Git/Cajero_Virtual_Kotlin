package com.medrano.tarea_s8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.medrano.tarea_s8.ui.theme.Tarea_S8Theme

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
fun TopAppBar(modifier: Modifier = Modifier) {
    var showMenu by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Inicio") }

    Scaffold(
        topBar = {
            
        }
    ){  }
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}