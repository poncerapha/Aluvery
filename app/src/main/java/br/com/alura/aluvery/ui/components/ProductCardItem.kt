package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.extensions.toBrazilianCurrency
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun ProductCardItem(
    product: Product,
    elevation: Dp = 4.dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = elevation
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            product.description?.let { description ->
                Text(
                    text = description,
                    Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardItemPreview() {
    AluveryTheme {
        Surface {
            ProductCardItem(
                product = Product(
                    name = "Pizza",
                    price = BigDecimal("15,99")
                ),
            )
        }
    }
}

@Preview
@Composable
private fun ProductCardItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            ProductCardItem(
                product = Product(
                    name = "Pizza",
                    price = BigDecimal("15,99"),
                    description = LoremIpsum(50).values.first()
                ),
            )
        }
    }
}