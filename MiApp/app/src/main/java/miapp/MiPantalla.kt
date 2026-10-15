package miapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun MiPantalla()
{
    Row(
        modifier = Modifier.fillMaxSize()
    )
    {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(0.5F)
                .background(Color.Red)
        )
            {
            }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Blue)
        )
            {
            }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(0.2F)
                .background(Color.Yellow)
        )



    }

}