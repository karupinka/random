package ru.yandex.repinanr.data.room.bank

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.data.model.bank.BankEntity

@Dao
interface BankDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertBank(bank: BankEntity)

    @Query("DELETE FROM BANKS WHERE id=:id")
    suspend fun deleteBank(id: Long)

    @Query("SELECT * FROM BANKS")
    suspend fun getAllBanks(): List<BankEntity>

    @Query("SELECT * FROM BANKS WHERE id=:id")
    suspend fun getBank(id: Long): BankEntity?
}