package cripto.potencial.tjdian.features.cryptocurrency.domain

data class CoinModel(
    val image: String?,
    val id: String?,
    val name: String?,
    val symbol: String?,
    val current_price:Any?,
    val market_cap: Any?,
    val total_supply: Any?,

)

data class ImageModel(
    val large: String,
    val small: String,
    val thumb: String
)

