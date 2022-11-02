package edu.ucne.repasoapi.ui.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.ucne.repasoapi.data.remote.Entidad

@Composable
fun EntidadItem(
    entidad : Entidad,
    onClick : (Entidad) -> Unit
    ) {
    Column(
        modifier = Modifier
            .padding(8.dp).clickable {onClick(entidad)}
    )
    {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${entidad.descripcion}",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${entidad.valor}",
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