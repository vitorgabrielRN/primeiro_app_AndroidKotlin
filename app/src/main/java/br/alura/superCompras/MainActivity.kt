package br.alura.superCompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.alura.superCompras.ui.theme.SuperComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImagemTopo(modifier = Modifier.padding(innerPadding))
                    icone(modifier  = Modifier.padding(innerPadding),
                        icone =  Icons.Default.Delete)
                }
            }
        }
    }
}

@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.logo),
        contentDescription = null,
        modifier = modifier.size(160.dp)
    )
}


@Composable
fun icone (icone: ImageVector,modifier: Modifier = Modifier) {
    Icon(icone, contentDescription = "Editar", modifier = modifier)
}

@Preview
@Composable
private fun icone() {
    SuperComprasTheme {
        icone(Icons.Default.Delete)
    }

}

@Preview
@Composable
private fun imagemPreview() {
    SuperComprasTheme {
        ImagemTopo()
    }
}


@Composable
fun Titulo(modifier: Modifier = Modifier) {
    Text(
        text ="Lista de teste", modifier = modifier)

}

@Preview
@Composable
private fun TituloPreview() {
    SuperComprasTheme {
        Titulo()
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Vitor!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperComprasTheme {
        Greeting("Android")
    }
}