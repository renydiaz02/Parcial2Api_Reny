package edu.ucne.repasoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.repasoapi.View.VerboViewModel
import edu.ucne.repasoapi.data.remote.Verbodto
import edu.ucne.repasoapi.ui.theme.RepasoApiTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepasoApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Principal()
                }
            }
        }
    }
}

@Composable
fun Principal(viewModel: VerboViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState()
    LazyColumn {
        items(state.value.verbos) { verbo ->
            verbosCard(verbo = verbo)
        }
    }
}

@Composable
fun verbosCard(
    modifier: Modifier = Modifier,
    verbo: Verbodto
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(vertical = 16.dp, horizontal = 14.dp),
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${verbo.Verbo}",
            )
            Text(
                text = "${verbo.Categoria}",
            )
            Text(
                text = "${verbo.Nivel}",
            )
            AsyncImage(
                model = verbo.Imagen,
                contentDescription = null,
                modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}