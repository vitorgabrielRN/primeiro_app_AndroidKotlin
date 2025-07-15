package br.alura.superCompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.alura.superCompras.ui.theme.SuperComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Titulo(modifier = Modifier.padding(innerPadding))
                    ImagemTopo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.images), contentDescription = null, modifier = modifier)
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