package cripto.potencial.tjdian.features.cryptocurrency.domain

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Description
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Image
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Links
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.MarketData

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
    val block_time_in_minutes: String?,
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
    val current_price: CurrentPriceModel?,
    val market_cap: MarketCapModel,
    val total_supply: String?
)

data class CurrentPriceModel(
    val eur: Float,
    val usd: Float,

    )

data class MarketCapModel(
    val eur: Long,
    val usd: Long,
)









