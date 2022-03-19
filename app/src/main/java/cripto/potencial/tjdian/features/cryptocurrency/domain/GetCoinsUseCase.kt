package cripto.potencial.tjdian.features.cryptocurrency.domain

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CryptoRepository) {
    suspend fun execute(): Result<List<CoinModel>> = repository.fetchCoins()
}