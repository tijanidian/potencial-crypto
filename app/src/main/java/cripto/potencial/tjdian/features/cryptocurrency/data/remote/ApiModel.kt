package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

data class CoinApiModel(
    val id: String,
    val name: String,
    val symbol1: String,
    val rank: String,
    val is_new: String,
    val is_active: String,
    val type: String
) {
    fun toModel(): CoinModel = CoinModel(
        id, name, symbol1, rank, is_new, is_active, type
    )
}