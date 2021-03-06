package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.app.domain.ErrorApp
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinDetailModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoRemoteSource @Inject constructor(private val cryptoApiClient: CryptoApiClient) :
    RemoteDataSource {

    override suspend fun getAllCoins(): Result<List<CoinModel>> = withContext(Dispatchers.IO) {

        try {
            val coinsApiModel = cryptoApiClient.getAllCoins()
            val coinsModel = mutableListOf<CoinModel>()

            coinsApiModel.mapCatching {
                it.map { coinApiModel ->
                    coinsModel.add(coinApiModel.toModel())
                }
            }
            Result.success(coinsModel)

        } catch (ex: Exception) {
            Result.failure(ErrorApp.ServerError)
        }

    }

    override suspend fun getCoin(coinId: String): CoinDetailModel? = withContext(Dispatchers.IO) {
         cryptoApiClient.getCoin(coinId)?.toModel()
    }


}