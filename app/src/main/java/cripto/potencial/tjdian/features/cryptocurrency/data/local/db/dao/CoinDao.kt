package cripto.potencial.tjdian.features.cryptocurrency.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.entities.CoinEntity

@Dao
interface CoinDao {

    @Transaction
    @Query("SELECT * from coins")
    fun findAll(): List<CoinEntity>

    @Insert
    fun saveCoins(vararg coinEntity: CoinEntity)

    @Transaction
    @Query("SELECT * FROM coins WHERE id= :coinId LIMIT 1")
    fun findById(coinId: String): CoinEntity


}