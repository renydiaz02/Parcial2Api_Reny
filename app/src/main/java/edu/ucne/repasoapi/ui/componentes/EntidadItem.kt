package edu.ucne.repasoapi.ui.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import edu.ucne.repasoapi.data.remote.Verbo

@Composable
fun EntidadItem(
    verbo : Verbo,
    onClick : (Verbo) -> Unit
    ) {
    Column(
        modifier = Modifier
            .padding(8.dp).clickable {onClick(verbo)}
    )
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(verbo.image)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = null
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${coin.descripcion}",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${NumberFormatD(coin.valor)}",
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.End,
                color = Color.Green
            )
        }

        Spacer(
            modifier = Modifier
                .height(3.dp)
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .width(2.dp),
            color = Color.DarkGray
        )

    }

}