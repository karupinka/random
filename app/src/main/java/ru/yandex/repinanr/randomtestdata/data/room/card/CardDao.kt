package ru.yandex.repinanr.randomtestdata.data.room.card

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardEntity

@Dao
interface CardDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertCard(card: CreditCardEntity)

    @Query("DELETE FROM CREDIT_CARDS WHERE id=:id")
    suspend fun deleteCard(id: Long)

    @Query("SELECT * FROM CREDIT_CARDS")
    suspend fun getAllCard(): List<CreditCardEntity>

    @Query("SELECT * FROM CREDIT_CARDS WHERE id=:id")
    suspend fun getCard(id: Long): CreditCardEntity?
}