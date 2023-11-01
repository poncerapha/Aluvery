package br.com.alura.aluvery.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.com.alura.aluvery.sampledata.sampleProducts

class HomeScreenUIState(searchText: String = "") {

    var text by mutableStateOf(searchText)

    val onStateChange: (String) -> Unit = {
        text = it
    }

    val searchedProducts get() =
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

    fun isShowSection() : Boolean {
        return text.isBlank()
    }
}