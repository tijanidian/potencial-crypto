package cripto.potencial.tjdian.features.cryptocurrency.data

import cripto.potencial.tjdian.features.cryptocurrency.data.local.CryptoLocalSource
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.RemoteDataSource
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinDetailModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CryptoRepository
import javax.inject.Inject

class CryptoDataRepository @Inject constructor(
    private val remoteSource: RemoteDataSource,
    private val localSource: CryptoLocalSource

) :
    CryptoRepository {

    override suspend fun fetchCoins(): Result<List<CoinModel>> {
        val localCoins = localSource.getCoins()

        return if (localCoins.getOrDefault(emptyList()).isEmpty()) {
            val remoteCoin = remoteSource.getAllCoins()
            remoteCoin.mapCatching {
                localSource.saveCoins(it)
                it
            }
        } else {
            localCoins
        }
    }

    override suspend fun fetchCoin(coinId: String): CoinDetailModel? {
        return remoteSource.getCoin(coinId)

    }


}