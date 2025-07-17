package br.alura.superCompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.alura.superCompras.ui.theme.SuperComprasTheme
import br.alura.superCompras.ui.theme.Typography
import br.alura.superCompras.ui.theme.azulMeio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {

                        ImagemTopo(modifier = Modifier.padding(innerPadding))

                        Titulo(
                            texto = "Gerenciando Clientes",
                            modifier = Modifier.padding(innerPadding)
                        )

                        Titulo(
                            texto = "Escolha qual seleção",
                            modifier = Modifier.padding(innerPadding)
                        )

                        ItemDaLista(modifier = Modifier.padding(innerPadding))

                    }
                }
            }
        }
    }

    @Composable
    fun ImagemTopo(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = modifier.size(137.dp, height = 32.dp)
        )
    }

    @Preview
    @Composable
    private fun ImagemTopo() {
        SuperComprasTheme {
            ImagemTopo()
        }

    }


    @Composable
    fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
        Icon(
            icone, contentDescription = "Editar",
            modifier = modifier,
            tint = azulMeio
        )
    }


    @Composable
    fun ItemDaLista(modifier: Modifier = Modifier) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = modifier
                    .padding(end = 200.dp)
                    .size(19.dp)
            )
            Text(
                text = "Suco",
                modifier = modifier,
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Icone(Icons.Default.Delete, modifier = modifier.size(16.dp))
            Icone(Icons.Default.Edit, modifier = modifier.size(16.dp))
        }
        Text("Gerenciamento de clientes",
            Modifier.padding(top = 1.dp),
            style = Typography.labelSmall,
            color = azulMeio)
    }


    @Preview
    @Composable
    private fun ItemDaLista() {
        SuperComprasTheme {
            ItemDaLista()
        }

    }


    @Composable
    fun Titulo(texto: String, modifier: Modifier = Modifier) {

        Text(
            text = texto,
            style = Typography.headlineLarge,
            modifier = modifier
        )

    }

    @Preview
    @Composable
    private fun TituloPreview() {
        SuperComprasTheme {
            Titulo(texto = " Gerenciamneto")
        }

    }

    @Preview
    @Composable
    private fun Icone() {
        SuperComprasTheme {
            Icone(Icons.Default.Delete)
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SuperComprasTheme {
            Greeting("Android")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Vitor!",
        modifier = modifier
    )
}

