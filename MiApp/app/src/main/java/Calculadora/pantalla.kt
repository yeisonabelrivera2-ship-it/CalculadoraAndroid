package Calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable

fun ComponentePantalla()
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF7FBFF)
            ),
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .shadow(
                    elevation = 25.dp,
                    shape = RoundedCornerShape(35.dp)
                )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFEFFFFF),
                            Color(0xFFDDF5FC),
                            Color(0xFFF9FDFF),
                            Color(0xFFC7E8F3)
                        )
                    ),
                    shape = RoundedCornerShape(35.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(35.dp)
                )
                .padding(15.dp)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.85f),
                                Color.White.copy(alpha = 0.20f)
                            )
                        )
                    )
            )

        }
    }
}
