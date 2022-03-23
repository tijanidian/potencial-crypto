package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import android.util.Log
import cripto.potencial.tjdian.app.domain.ErrorApp
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CryptoApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoApiClient @Inject constructor(private val cryptoApiEndPoint: CryptoApiEndPoint) {

    suspend fun getAllCoins(): Result<List<CryptoApiModel>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val call = cryptoApiEndPoint.getCoins()
            if (call.isSuccessful) {
                Result.success(call.body() ?: mutableListOf())
            } else {
                Result.success(mutableListOf())
            }
        } catch (ex: Exception) {
            Result.failure(ErrorApp.ServerError)
        }
    }
}