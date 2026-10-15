package Calculadora

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComponenteResultado(resultado: String)
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 30.dp,
                end = 30.dp,
                top = 45.dp
            )
            .height(280.dp),
        contentAlignment = Alignment.CenterEnd
    )
    {
        Text(
            text = resultado,
            color = Color.Black,
            fontSize = when
            {
                resultado.length > 30 -> 28.sp
                resultado.length > 22 -> 34.sp
                resultado.length > 14 -> 40.sp
                else -> 55.sp
            },
            lineHeight = 62.sp,
            maxLines = 3,
            softWrap = true,
            overflow = TextOverflow.Clip,
            textAlign = TextAlign.End
        )
    }
}