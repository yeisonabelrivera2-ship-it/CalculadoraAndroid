package Calculadora

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun ComponenteBoton(texto: String,
                    modifier: Modifier = Modifier,
                    alPulsar: () -> Unit)
{
    Button(
        modifier = modifier
            .aspectRatio(1f),
        onClick = alPulsar,
        shape = RoundedCornerShape(7.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = when (texto)
            {
                "=" -> Color(0xFF4F78A8)
                "⌦" -> Color.Red
                "C" -> Color.Gray
                else -> Color(0xFFEFFFFF)
            }
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 30.dp
        )
    )
    {
        Text(
            text = texto,
            color = Color(0xFF2A4A55),
            fontSize = 24.sp
        )
    }
}



@Composable
fun ComponenteTeclado(alPulsar: (String) -> Unit)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp)
            .offset(y = 180.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            ComponenteBoton("C", modifier = Modifier.weight(1f), alPulsar = { alPulsar("C") })
            ComponenteBoton("(", modifier = Modifier.weight(1f), alPulsar = { alPulsar("(") })
            ComponenteBoton(")",  modifier = Modifier.weight(1f), alPulsar = { alPulsar(")") })
            ComponenteBoton("/",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("/") })
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            ComponenteBoton("7",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("7") })
            ComponenteBoton("8",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("8") })
            ComponenteBoton("9",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("9") })
            ComponenteBoton("x",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("x") })
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            ComponenteBoton("4",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("4") })
            ComponenteBoton("5",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("5") })
            ComponenteBoton("6",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("6") })
            ComponenteBoton("-",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("-") })
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            ComponenteBoton("1",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("1") })
            ComponenteBoton("2",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("2") })
            ComponenteBoton("3",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("3") })
            ComponenteBoton("+",  modifier = Modifier.weight(1f), alPulsar = { alPulsar("+") })
        }

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            ComponenteBoton("0", modifier = Modifier.weight(1f), alPulsar = { alPulsar("0") })
            ComponenteBoton(".", modifier = Modifier.weight(1f), alPulsar = { alPulsar(".") })
            ComponenteBoton("⌦", modifier = Modifier.weight(1f), alPulsar = { alPulsar("⌦") })
            ComponenteBoton("=", modifier = Modifier.weight(1f), alPulsar = { alPulsar("=") })
        }
    }
}