package br.com.alura.aluvery.states

data class ProductFromScreenUIState(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val onUrlChange: (String) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {},
) {
    val isShowPreview: Boolean = url.isNotBlank()
}