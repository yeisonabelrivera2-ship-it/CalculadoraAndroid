package miapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Ejercicio1()
{
    Row(modifier = Modifier.fillMaxSize()
                           .padding(7.dp)
                           .background(Color.Black)
    )
    {
        Box(
            modifier = Modifier.weight(1f)
                               .fillMaxHeight(0.6f)
                               .padding(7.dp)
                               .background(Color.Red)
        )
        {}
        Box(
            modifier = Modifier.weight(0.8f)
                               .fillMaxHeight(0.9f)
                               .padding(7.dp)
                               .background(Color.Yellow)
        )
        {}
        Box(
            modifier = Modifier.weight(1f)
                               .fillMaxHeight(0.7f)
                               .padding(7.dp)
                               .background(Color.Blue)
        )

    }
}