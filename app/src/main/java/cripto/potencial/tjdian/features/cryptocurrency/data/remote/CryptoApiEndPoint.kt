package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.CryptoDetailApiModel
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CryptoApiModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApiEndPoint {
    @GET("/api/v3/coins/?localization=false&tickers=false&market_data=true&community_data=true&sparkline=false")
    suspend fun getCoins(): Response<List<CryptoApiModel>>

    @GET("/api/v3/coins/{coin_id}?localization=false&tickers=false&market_data=true&community_data=true&sparkline=false")
    fun getCoin(@Path("coin_id") coin_id: String): Call<CryptoDetailApiModel>
}

