package cripto.potencial.tjdian.features.cryptocurrency.data.local.db

import cripto.potencial.tjdian.app.domain.ErrorApp
import cripto.potencial.tjdian.features.cryptocurrency.data.local.CryptoLocalSource
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.dao.CoinDao
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities.CoinEntity
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoDbLocalSource @Inject constructor(private val coinDao: CoinDao) : CryptoLocalSource {
    override suspend fun getCoin(coinId: String): Result<CoinModel> = withContext(Dispatchers.IO) {

        try {
            val coin = coinDao.findById(coinId)
            Result.success(coin.toModel())
        } catch (ex: Exception) {
            Result.failure(ErrorApp.DataError)
        }
    }

    override suspend fun getCoins(): Result<List<CoinModel>> = withContext(Dispatchers.IO) {
        try {
            val coins = coinDao.findAll()
                .map {
                    it.toModel()
                }
            Result.success(coins)
        } catch (ex: Exception) {
            Result.failure(ErrorApp.DataError)
        }
    }

    override suspend fun saveCoin(coinModel: CoinModel): Result<Boolean> =
        withContext(Dispatchers.IO) {
            try {
                coinDao.saveCoins(CoinEntity.modelToEntity(coinModel))
                Result.success(true)

            } catch (ex: Exception) {
                Result.failure(ErrorApp.DataError)
            }
        }

    override suspend fun saveCoins(coinModel: List<CoinModel>): Result<Boolean> =
        withContext(Dispatchers.IO) {
            try {
                coinModel.forEach {
                    coinDao.saveCoins(CoinEntity.modelToEntity(it))
                }
                Result.success(true)
            } catch (ex: Exception) {
                Result.failure(ErrorApp.DataError)
            }
        }


}