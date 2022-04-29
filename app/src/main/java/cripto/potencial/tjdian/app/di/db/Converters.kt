package cripto.potencial.tjdian.app.di.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities.CoinMarketDataLocalModel
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities.ImageLocalModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CurrentPriceModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.MarketCapModel


class Converters {

    @TypeConverter
    fun jsonToImageModel(json:String): ImageLocalModel = Gson().fromJson(
        json,object : TypeToken<ImageLocalModel>(){}.type
    )

    @TypeConverter
    fun imageModelToJson(model:ImageLocalModel):String = Gson().toJson(
        model,object : TypeToken<ImageLocalModel>(){}.type
    )

    @TypeConverter
    fun jsonToCoinMarketDataLocalModel(json:String): CoinMarketDataLocalModel = Gson().fromJson(
        json,object : TypeToken<CoinMarketDataLocalModel>(){}.type
    )

    @TypeConverter
    fun coinMarketDataLocalModelToJson(model:CoinMarketDataLocalModel):String = Gson().toJson(
        model,object : TypeToken<CoinMarketDataLocalModel>(){}.type
    )

    @TypeConverter
    fun jsonToCurrentPriceModel(json:String): CurrentPriceModel = Gson().fromJson(
        json,object : TypeToken<CurrentPriceModel>(){}.type
    )

    @TypeConverter
    fun currentPriceModelToJson(model:CurrentPriceModel):String = Gson().toJson(
        model,object : TypeToken<CurrentPriceModel>(){}.type
    )

    @TypeConverter
    fun jsonToMarketCapModel(json:String): MarketCapModel = Gson().fromJson(
        json,object : TypeToken<MarketCapModel>(){}.type
    )

    @TypeConverter
    fun marketCapModelToJson(model:MarketCapModel):String = Gson().toJson(
        model,object : TypeToken<MarketCapModel>(){}.type
    )
}
