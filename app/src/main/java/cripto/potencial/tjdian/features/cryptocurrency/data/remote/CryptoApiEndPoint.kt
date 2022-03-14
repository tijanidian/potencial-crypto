package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface CryptoApiEndPoint {
    @GET("https://api.coinpaprika.com/v1/coins/")
    suspend fun getCoins(): Response<List<CoinApiModel>>
}