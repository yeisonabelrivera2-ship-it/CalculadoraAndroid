package com.example.miapp

import Calculadora.iniciarApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.miapp.ui.theme.MiAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiAppTheme {
                //aqui invoco a mi pantalla

                iniciarApp()

            }
        }
    }
}
