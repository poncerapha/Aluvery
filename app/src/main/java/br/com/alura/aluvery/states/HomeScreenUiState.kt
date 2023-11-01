package br.com.alura.aluvery.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleProducts

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    searchText: String = ""
) {

    var text by mutableStateOf(searchText)
        private set

    val searchedProducts
        get() =
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(
                        text,
                        ignoreCase = true,
                    ) ||
                        product.description?.contains(
                            text,
                            ignoreCase = true,
                        ) ?: false
                }
            } else emptyList()

    fun isShowSections(): Boolean {
        return text.isBlank()
    }

    val onSearchChange: (String) -> Unit = { searchText ->
        text = searchText
    }
}