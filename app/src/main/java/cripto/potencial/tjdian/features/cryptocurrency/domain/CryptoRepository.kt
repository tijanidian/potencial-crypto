package cripto.potencial.tjdian.features.cryptocurrency.domain

interface CryptoRepository {
    suspend fun fetchCoins(): Result<List<CoinModel>>
}