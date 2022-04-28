package cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel

import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

data class CryptoApiModel(
    val block_time_in_minutes: String,
    val id: String,
    val image: Image,
    val last_updated: String,
    val market_data: MarketData,
    val name: String,
    val symbol: String
){
    fun toModel():CoinModel= CoinModel(block_time_in_minutes,id,image.toModel(),last_updated,market_data.toModel(),name, symbol)
}