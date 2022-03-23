package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CryptoApiModel
import retrofit2.Response
import retrofit2.http.GET

interface CryptoApiEndPoint {
    @GET("/api/v3/coins/?localization=false&tickers=false&market_data=true&community_data=true&sparkline=false")
    suspend fun getCoins(): Response<List<CryptoApiModel>>
}

