package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remotemodels.*
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

data class CoinApiModel(
    val block_time_in_minutes: String?,
    val id: String,
    val image: Image?,
    val last_updated: String?,
    val name: String,
    /*val market_data: MarketData,*/
    val symbol: String
) {
    fun toModel(): CoinModel = CoinModel(
        block_time_in_minutes,id,image?.toModel(),last_updated,/*,market_data*/ name, symbol
    )
}