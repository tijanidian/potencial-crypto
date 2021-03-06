package cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel

import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinDetailModel

data class CryptoDetailApiModel(
    val additional_notices: List<Any>,
    val asset_platform_id: Any,
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val coingecko_rank: Int,
    val coingecko_score: Double,
    val community_data: CommunityData,
    val community_score: Double,
    val country_origin: String,
    val description: Description,
    val developer_data: DeveloperData,
    val developer_score: Double,
    val genesis_date: Any?,
    val hashing_algorithm: String?,
    val id: String,
    val image: Image,
    val last_updated: String,
    val links: Links,
    val liquidity_score: Double,
    val market_cap_rank: Int,
    val market_data: MarketData,
    val name: String,
    val platforms: Platforms,
    val public_interest_score: Double,
    val public_interest_stats: PublicInterestStats,
    val public_notice: Any,
    val sentiment_votes_down_percentage: Double,
    val sentiment_votes_up_percentage: Double,
    val status_updates: List<Any>,
    val symbol: String
){
    fun toModel():CoinDetailModel{
        return CoinDetailModel(block_time_in_minutes, categories, country_origin, description, genesis_date, hashing_algorithm, id, image, last_updated, links, market_data, name, public_interest_score, symbol)
    }
}