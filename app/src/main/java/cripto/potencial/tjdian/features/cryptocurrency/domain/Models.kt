package cripto.potencial.tjdian.features.cryptocurrency.domain

data class CoinModel(
    val block_time_in_minutes: String?,
    val id: String?,
    val image: ImageModel?,
    val last_updated: String?,
    /*val market_data: MarketData,*/
    val name: String?,
    val symbol: String?
)

data class ImageModel(
    val large: String,
    val small: String,
    val thumb: String
)

