package Calculadora

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun iniciarApp()
{
    val resultado = remember()
    {
        mutableStateOf("0")
    }

    val calculadora = remember()
    {
        CalculadoraLogica()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        ComponentePantalla()

        ComponenteResultado(resultado.value)

        ComponenteTeclado(
            alPulsar = { tecla ->
                resultado.value = calculadora.pulsar(tecla)
            }
        )
    }
}