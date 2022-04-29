package cripto.potencial.tjdian.features.cryptocurrency.domain

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Description
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Image
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Links
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.MarketData
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CurrentPrice
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.MarketCap

data class CoinDetailModel(
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val country_origin: String,
    val description: Description,
    val genesis_date: Any?,
    val hashing_algorithm: String?,
    val id: String,
    val image: Image,
    val last_updated: String,
    val links: Links,
    val market_data: MarketData,
    val name: String,
    val public_interest_score: Double,
    val symbol: String,
)


data class CoinModel(
    val block_time_in_minutes: Any?,
    val id: String,
    val image: ImageModel,
    val last_updated: String,
    val market_data: MarketDataModel,
    val name: String,
    val symbol: String
)

data class ImageModel(
    val large: String,
    val small: String,
    val thumb: String
)

data class MarketDataModel(
    val current_price: CurrentPrice,
    val market_cap: MarketCap,
    val total_supply: String?

)









