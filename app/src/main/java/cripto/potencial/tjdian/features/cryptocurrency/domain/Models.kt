package cripto.potencial.tjdian.features.cryptocurrency.domain

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Description
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Image
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Links
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.MarketData

data class CoinDetailModel(
    val blockTimeInMinutes: Int,
    val categories: List<String>,
    val countryOrigin: String,
    val description: Description,
    val genesisDate: Any?,
    val hashingAlgorithm: String?,
    val id: String,
    val image: Image,
    val lastUpdated: String,
    val links: Links,
    val marketData: MarketData,
    val name: String,
    val publicInterestScore: Double,
    val symbol: String,
)


data class CoinModel(
    val blockTimeInMinutes: String?,
    val id: String,
    val image: ImageModel,
    val lastupDated: String,
    val marketData: MarketDataModel,
    val name: String,
    val symbol: String
)

data class ImageModel(
    val large: String,
    val small: String,
    val thumb: String
)

data class MarketDataModel(
    val currentPrice: CurrentPriceModel?,
    val marketCap: MarketCapModel,
    val totalSupply: String?
)

data class CurrentPriceModel(
    val eur: Float,
    val usd: Float,
)

data class MarketCapModel(
    val eur: Long,
    val usd: Long,
)









