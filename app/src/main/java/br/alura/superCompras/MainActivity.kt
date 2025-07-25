package br.alura.superCompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
                      ListaDeCompras(Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Composable
    fun ListaDeCompras(modifier: Modifier = Modifier) {
        var ListaDeItens = rememberSaveable { mutableListOf<ItemDeCompra>()}

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding()) {

            ImagemTopo()

            AdicionarItem( salvarItem = {
                ListaDeItens.add(ItemDeCompra(Texto = "Suco"))
            })

            Spacer( Modifier.height(48.dp))

            Titulo(
                texto = "Lista de compras",
            )
            Column {
                    ListaDeItens.forEach{ item ->
                        ItemDaLista(item)
                    }
            }
            Titulo(
                texto = "Comprado",
            )
        }

    }

    @Composable
    fun AdicionarItem( salvarItem: (texto:String) -> Unit,modifier: Modifier = Modifier) {
        var texto = rememberSaveable()  { mutableStateOf(" ") }
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

        Button(
            shape = RoundedCornerShape(24.dp),
            onClick = {
                salvarItem(texto.value)
                texto.value = ""
            },
            modifier = modifier

            ) {
            Text(text = "Salvar item",
                color = Color.White,
                style = Typography.bodyMedium,
                modifier =   Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
            )

            }

    }

    @Composable
    fun ItemDaLista(item: ItemDeCompra,modifier: Modifier = Modifier) {


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
                text = item.Texto,
                modifier = Modifier.weight(1f),
                style = Typography.bodyMedium,
                textAlign = TextAlign.Start,

                )
            Icone(Icons.Default.Delete, modifier = modifier.size(20.dp))
            Icone(Icons.Default.Edit, modifier = modifier.size(20.dp))
        }
        Text(
            " ",
            Modifier.padding(top = 1.dp),
            style = Typography.labelSmall,
            color = coral
        )
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
            tint = marinho,

            )
    }

    @Composable
    fun Titulo(texto: String, modifier: Modifier = Modifier) {

        Text(
            text = texto,
            style = Typography.headlineLarge,
            modifier = modifier,
            color = coral
        )

    }

    @Preview
    @Composable
    private fun AdicionarItempreview() {
        SuperComprasTheme {
            AdicionarItem(salvarItem = {})
        }

    }


    @Preview
    @Composable
    private fun ItemDaListapreview() {
        SuperComprasTheme {
            ItemDaLista(item = ItemDeCompra(Texto = "Suco"))
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
            Titulo(texto = " lista de compras")
        }

    }
}

data class ItemDeCompra(
    val Texto:String
    )

