package cripto.potencial.tjdian.features.cryptocurrency.domain

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CurrentPrice
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.Image
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.MarketCap

data class CoinModel(
    val block_time_in_minutes: Any?,
    val id: String,
    val image: Image,
    val last_updated: String,
    val market_data: MarketDataModel,
    val name: String,
    val symbol: String
)


data class CurrentPriceModel(
    val eur: Int,
    val usd: Int,
)

data class High24hModel(
    val eur: Int,
    val usd: Int,
)

data class ImageModel(
    val large: String,
    val small: String,
    val thumb: String
)

data class Low24hModel(
    val eur: Int,
    val usd: Int,
)

data class MarketCapModel(
    val eur: Int,
    val usd: Int,
)

data class MarketCapChange24hInCurrencyModel(
    val eur: Int,
    val usd: Int,

    )

data class MarketCapChangePercentage24hInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class MarketDataModel(
    val current_price: CurrentPrice,
    val market_cap:MarketCap,
    val total_supply:String?

)

data class PriceChange24hInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class PriceChangePercentage1hInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class PriceChangePercentage7dInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class PriceChangePercentage14dInCurrencyModel(
    val eur: Int,
    val usd: Int,
)


data class PriceChangePercentage24hInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class PriceChangePercentage30dInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class PriceChangePercentage60dInCurrencyModel(
    val eur: Int,
    val usd: Int,
)


data class PriceChangePercentage200dInCurrencyModel(
    val eur: Int,
    val usd: Int,
)

data class TotalVolumeModel(
    val eur: Int,
    val usd: Int,
)

data class PriceChangePercentage1yInCurrencyModel(
    val eur: Int,
    val usd: Int,
)