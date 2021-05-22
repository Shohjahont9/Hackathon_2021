package shohjahon.example.akfa_app.network.response.items

data class ItemsResponse(
    val `data`: List<DataItems>?,
    val message: String?,
    val status: Int?
)