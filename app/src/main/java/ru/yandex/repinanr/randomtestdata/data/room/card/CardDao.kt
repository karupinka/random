package ru.yandex.repinanr.randomtestdata.data.room.card

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardEntity

@Dao
interface CardDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertCard(card: CreditCardEntity)

    @Delete
    suspend fun deleteCard(card: CreditCardEntity)

    @Query("DELETE FROM CREDIT_CARDS WHERE id=:id")
    suspend fun deleteCard(id: String)

    @Query("SELECT * FROM CREDIT_CARDS")
    fun getAllCard(): LiveData<List<CreditCardEntity>>

    @Query("SELECT * FROM CREDIT_CARDS WHERE id=:id")
    suspend fun getCard(id: String): CreditCardEntity?
}