package cripto.potencial.tjdian.features.cryptocurrency.data

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.RemoteDataSource
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinDetailModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CryptoRepository
import javax.inject.Inject

class CryptoDataRepository @Inject constructor(private val remoteSource: RemoteDataSource) :
    CryptoRepository {

    override suspend fun fetchCoins(): Result<List<CoinModel>> = remoteSource.getAllCoins()
    override suspend fun fetchCoin(coinId: String): CoinDetailModel? = remoteSource.getCoin(coinId)



}