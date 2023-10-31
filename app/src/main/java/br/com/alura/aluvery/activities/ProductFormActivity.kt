package br.com.alura.aluvery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductForm()
                }
            }
        }
    }
}

@Composable
fun ProductForm() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var url by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }

        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = "Criando um Produto",
            fontSize = 28.sp,
            fontWeight = FontWeight(400)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = url,
            label = {
                Text(text = "Url da imagem")
            },
            onValueChange = {
                url = it
            })

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            label = {
                Text(text = "Nome")
            },
            onValueChange = {
                name = it
            }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = price,
            label = {
                Text(text = "Preço")
            },
            onValueChange = {
                price = it
            }
        )

        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            label = {
                Text(text = "Descrição")
            },
        )

        Button(
            onClick = { /*TODO*/ }) {
            Text(
                text = "Salvar",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductFromPreview() {
    AluveryTheme {
        Surface {
            ProductForm()
        }
    }
}