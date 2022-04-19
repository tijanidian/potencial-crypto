package cripto.potencial.tjdian.app.di.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.dao.CoinDao
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities.CoinEntity


@Database(
    entities = [CoinEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun coinDao(): CoinDao
}