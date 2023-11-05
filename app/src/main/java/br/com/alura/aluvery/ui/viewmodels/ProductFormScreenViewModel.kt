package br.com.alura.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.alura.aluvery.dao.ProductDao
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.states.ProductFromScreenUIState
import java.math.BigDecimal
import java.text.DecimalFormat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductFormScreenViewModel : ViewModel() {
    private val _uIState: MutableStateFlow<ProductFromScreenUIState> = MutableStateFlow(
        ProductFromScreenUIState()
    )

    val uiState get() = _uIState.asStateFlow()

    private val formatter = DecimalFormat("#.##")
    private val dao = ProductDao()

    init {
        _uIState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uIState.value = _uIState.value.copy(
                        url = it
                    )
                },
                onNameChange = {
                    _uIState.value = _uIState.value.copy(
                        name = it
                    )
                },
                onPriceChange = {
                    val price = try {
                        formatter.format(BigDecimal(it))
                    } catch (e: IllegalArgumentException) {
                        if (it.isEmpty()) {
                            it
                        } else {
                            null
                        }
                    }
                    price?.let {
                        _uIState.value = _uIState.value.copy(
                            price = price
                        )
                    }
                },
                onDescriptionChange = {
                    _uIState.value = _uIState.value.copy(
                        description = it
                    )
                },
            )
        }
    }

    fun saveProduct() {
        _uIState.value.run {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )

            dao.saveProduct(product = product)
        }
    }
}