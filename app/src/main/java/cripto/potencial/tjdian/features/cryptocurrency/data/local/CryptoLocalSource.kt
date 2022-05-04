package cripto.potencial.tjdian.features.cryptocurrency.data.local

import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

interface CryptoLocalSource {
    suspend fun getCoin(coinId: String): Result<CoinModel>
    suspend fun getCoins(): Result<List<CoinModel>>
    suspend fun saveCoins(coinModel: List<CoinModel>): Result<Boolean>
    suspend fun saveCoin(coinModel: CoinModel): Result<Boolean>
}