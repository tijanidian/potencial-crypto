package cripto.potencial.tjdian.features.cryptocurrency.data.remote.remotemodels

data class prueba(
    val block_time_in_minutes: String,
    val id: String,
    val image: Image,
    val last_updated: String,
    val market_data: MarketData,
    val name: String,
    val symbol: String
)