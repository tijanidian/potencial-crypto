package cripto.potencial.tjdian.features.cryptocurrency.domain

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CryptoRepository) {
    suspend fun execute(coinId:String):CoinDetailModel? = repository.fetchCoin(coinId)
}