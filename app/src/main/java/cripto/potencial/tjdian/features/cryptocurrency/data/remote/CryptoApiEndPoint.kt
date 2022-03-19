package cripto.potencial.tjdian.features.cryptocurrency.data.remote

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CryptoApiModel
import retrofit2.Response
import retrofit2.http.GET

interface CryptoApiEndPoint {
    @GET("/api/v3/coins/markets?vs_currency=eur&order=market_cap_desc&per_page=100&page=1&sparkline=false")
    suspend fun getCoins(): Response<List<CryptoApiModel>>
}

