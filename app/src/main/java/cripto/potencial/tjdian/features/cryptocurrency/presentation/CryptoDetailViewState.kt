package cripto.potencial.tjdian.features.cryptocurrency.presentation

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Description
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Links
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.MarketData
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinDetailModel

data class CryptoDetailViewState(
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val country_origin: String,
    val description: Description,
    val genesis_date: Any?,
    val hashing_algorithm: String?,
    val id: String,
    val image: cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Image,
    val last_updated: String,
    val links: Links,
    val market_data: MarketData,
    val name: String,
    val public_interest_score: Double,
    val symbol: String,
){
    companion object{
        fun fromDetailModel(coin:CoinDetailModel)=CryptoDetailViewState(
            coin.block_time_in_minutes,
            coin.categories,
            coin.country_origin,
            coin.description,
            coin.genesis_date,
            coin.hashing_algorithm,
            coin.id,
            coin.image,
            coin.last_updated,
            coin.links,
            coin.market_data,
            coin.name,
            coin.public_interest_score,
            coin.symbol,
        )
    }
}

