package br.alura.superCompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.alura.superCompras.ui.theme.SuperComprasTheme
import br.alura.superCompras.ui.theme.Typography
import br.alura.superCompras.ui.theme.coral
import br.alura.superCompras.ui.theme.marinho

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme (){
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(innerPadding)
                    ) {
                        ImagemTopo()
                        AdicionarItem()
                        BotaoSalvarItem(onclick = {})
                        Titulo(
                            texto = "Gerenciando Clientes",
                        )
                        Titulo(
                            texto = "Escolha qual seleção",
                        )
                        ItemDaLista()


                    }
                }
            }
        }
    }

    @Composable
    fun ImagemTopo(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(R.drawable.paperbagwithgroceries1),
            contentDescription = null,
            modifier = modifier.size(160.dp, height = 160.dp)
        )
    }


    @Composable
    fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
        Icon(
            icone, contentDescription = "Editar",
            modifier = modifier,
            tint = coral
        )
    }


    @Composable
    fun ItemDaLista(modifier: Modifier = Modifier) {

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                modifier = modifier
                    .padding(end = 20.dp)
                    .size(19.dp)
            )
            Text(
                text = "Suco",
                modifier = Modifier.weight(1f),
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Icone(Icons.Default.Delete, modifier = modifier.size(16.dp))
            Icone(Icons.Default.Edit, modifier = modifier.size(16.dp))
        }
        Text(
            "Gerenciamento de clientes",
            Modifier.padding(top = 1.dp),
            style = Typography.labelSmall,
            color = marinho
        )
    }

    @Composable
    fun AdicionarItem(modifier: Modifier = Modifier) {
        var texto = rememberSaveable()  { mutableStateOf("") }
        OutlinedTextField(
            value = texto.value,
            onValueChange = { texto.value = it },
            placeholder = {Text("Digite a sua compra",
                color = Color.Gray,
                style = Typography.bodyMedium)
        },
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,
            shape = RoundedCornerShape(24.dp)
        )
    }

    @Composable
    fun BotaoSalvarItem(onclick:()-> Unit,modifier: Modifier = Modifier) {
     Button(shape = RoundedCornerShape(24.dp),
         onClick = onclick,
         modifier = modifier,
         contentPadding = PaddingValues(10.dp)

         ) {
         Text(text = "Salvar item", color = Color.White
         )

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
    private fun AdicionarItempreview() {
        SuperComprasTheme {
            AdicionarItem()
        }

    }


    @Preview
    @Composable
    private fun ItemDaListapreview() {
        SuperComprasTheme {
            ItemDaLista()
        }

    }

    @Preview
    @Composable
    private fun BotaoSalvarPreview() {
        SuperComprasTheme {
            BotaoSalvarItem(onclick = {})
        }
    }



    @Preview
    @Composable
    private fun Iconepreview() {
        SuperComprasTheme {
            Icone(Icons.Default.Delete)
        }

    }

    @Preview
    @Composable
    private fun ImagemTopoPreview() {
        SuperComprasTheme {
            ImagemTopo()
        }

    }

    @Preview
    @Composable
    private fun TituloPreview() {
        SuperComprasTheme {
            Titulo(texto = " Gerenciamneto")
        }

    }

}

