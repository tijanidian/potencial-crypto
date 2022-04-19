package cripto.potencial.tjdian.app.di.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities.CoinMarketDataLocalModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.CurrentPriceModel

@ProvidedTypeConverter
class Converters {

    @TypeConverter
    fun jsonToCoinModel(json:String):List<CoinModel> = Gson().fromJson(
        json,object : TypeToken<List<CoinModel>>(){}.type
    )

    @TypeConverter
    fun coinModelToJson(localModel: List<CoinModel>): String = Gson().toJson(
        localModel, object : TypeToken<List<CoinModel>>() {}.type
    )


    @TypeConverter
    fun jsonToMarketLocalModel(json:String):List<CoinMarketDataLocalModel> = Gson().fromJson(
        json,object : TypeToken<List<CoinMarketDataLocalModel>>(){}.type
    )

    @TypeConverter
    fun marketLocalModelToJson(localModel: List<CoinMarketDataLocalModel>): String = Gson().toJson(
        localModel, object : TypeToken<List<CoinMarketDataLocalModel>>() {}.type
    )

}
