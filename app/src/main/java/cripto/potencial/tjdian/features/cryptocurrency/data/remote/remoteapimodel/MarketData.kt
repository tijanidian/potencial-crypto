package cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel

import cripto.potencial.tjdian.features.cryptocurrency.domain.MarketDataModel

data class MarketData(
    val circulating_supply: String,
    val current_price: CurrentPrice,
    val high_24h: High24h,
    val low_24h: Low24h,
    val market_cap: MarketCap,
    val market_cap_change_24h: Double,
    val market_cap_change_24h_in_currency: MarketCapChange24hInCurrency,
    val market_cap_change_percentage_24h: Double,
    val market_cap_change_percentage_24h_in_currency: MarketCapChangePercentage24hInCurrency,
    val market_cap_rank: Int,
    val price_change_24h: Double,
    val price_change_24h_in_currency: PriceChange24hInCurrency,
    val price_change_percentage_14d: Double,
    val price_change_percentage_14d_in_currency: PriceChangePercentage14dInCurrency,
    val price_change_percentage_1h_in_currency: PriceChangePercentage1hInCurrency,
    val price_change_percentage_1y: Double,
    val price_change_percentage_1y_in_currency: PriceChangePercentage1yInCurrency,
    val price_change_percentage_200d: Double,
    val price_change_percentage_200d_in_currency: PriceChangePercentage200dInCurrency,
    val price_change_percentage_24h: Double,
    val price_change_percentage_24h_in_currency: PriceChangePercentage24hInCurrency,
    val price_change_percentage_30d: Double,
    val price_change_percentage_30d_in_currency: PriceChangePercentage30dInCurrency,
    val price_change_percentage_60d: Double,
    val price_change_percentage_60d_in_currency: PriceChangePercentage60dInCurrency,
    val price_change_percentage_7d: Double,
    val price_change_percentage_7d_in_currency: PriceChangePercentage7dInCurrency,
    val roi: Any,
    val total_supply: String?,
    val total_volume: TotalVolume
){
    fun toModel():MarketDataModel=MarketDataModel(
        current_price,
        market_cap,
        total_supply
    )
}