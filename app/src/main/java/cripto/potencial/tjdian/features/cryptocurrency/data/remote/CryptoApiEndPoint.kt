package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface CryptoApiEndPoint {
    @GET("/api/v3/coins/?localization=false")
    suspend fun getCoins(): Response<List<CoinApiModel>>
}