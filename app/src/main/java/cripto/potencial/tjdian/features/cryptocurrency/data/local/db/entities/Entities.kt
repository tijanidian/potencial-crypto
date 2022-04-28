package cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import cripto.potencial.tjdian.features.cryptocurrency.domain.*

@Entity(tableName = "coins")
data class CoinEntity(
    @PrimaryKey @ColumnInfo(name = "id") val coinId: String,
    @ColumnInfo(name = "block_time_in_minutes") val blockTime: String?,
    @ColumnInfo(name = "last_updated") val lastUpdate: String,
    @ColumnInfo(name = "name") val nameCoin: String,
    @ColumnInfo(name = "symbol") val symbolCoin: String,
    @Embedded(prefix = "coin_image") val imageLocalModel: ImageLocalModel,
    @Embedded(prefix = "coin_market_data") val coinMarketDataLocalModel: CoinMarketDataLocalModel,
) {
    fun toModel() = CoinModel(
        blockTime,
        coinId,
        imageLocalModel.toModel(),
        lastUpdate,
        coinMarketDataLocalModel.toModel(),
        nameCoin,
        symbolCoin,
    )

    companion object {
        fun modelToEntity(coinModel: CoinModel): CoinEntity = CoinEntity(
            coinModel.id,
            coinModel.block_time_in_minutes,
            coinModel.last_updated,
            coinModel.name,
            coinModel.symbol,
            ImageLocalModel.toLocalModel(coinModel.image),
            CoinMarketDataLocalModel.toLocalModel(coinModel.market_data)
        )
    }
}

data class ImageLocalModel(
    val large: String,
    val small: String,
    val thumb: String
) {
    fun toModel() = ImageModel(
        large, small, thumb
    )

    companion object {
        fun toLocalModel(imageModel: ImageModel) = ImageLocalModel(
            imageModel.large,
            imageModel.small,
            imageModel.thumb
        )
    }
}

data class CoinMarketDataLocalModel(
    val current_price: CurrentPriceModel? = null,
    val market_cap: MarketCapModel,
    val total_supply: String? = null
) {
    fun toModel() = MarketDataModel(
        current_price, market_cap, total_supply
    )

    companion object {
        fun toLocalModel(marketDataModel: MarketDataModel): CoinMarketDataLocalModel =
            CoinMarketDataLocalModel(
                marketDataModel.current_price,
                marketDataModel.market_cap,
                marketDataModel.total_supply
            )
    }
}

