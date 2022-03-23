package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinDetailModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

interface RemoteDataSource {
    suspend fun getAllCoins(): Result<List<CoinModel>>
    suspend fun getCoin(coinId:String): CoinDetailModel?
}