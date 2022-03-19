package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

data class RemoteApiModel(
    val ath: Any?,
    val ath_change_percentage: Any?,
    val ath_date: String?,
    val atl: Double?,
    val atl_change_percentage: Any?,
    val atl_date: String?,
    val circulating_supply: Any?,
    val fully_diluted_valuation: Any?,
    val high_24h: Any?,
    val id: String,
    val image: String?,
    val last_updated: String?,
    val low_24h: Any?,
    val market_cap: Any?,
    val market_cap_change_24h: Any?,
    val market_cap_change_percentage_24h: Any?,
    val market_cap_rank: Any?,
    val max_supply:Any?,
    val name: String,
    val price_change_24h: Any?,
    val price_change_percentage_24h: Any?,
    val roi: Any?,
    val symbol: String?,
    val total_supply: Any?,
    val total_volume: Any?,
    val current_price: Any?,
){
    fun toModel():CoinModel{
        return  CoinModel(image, id, name, symbol, current_price, market_cap, total_supply)
    }
}