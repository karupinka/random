package ru.yandex.repinanr.randomtestdata.data.room.bank

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.randomtestdata.data.model.bank.BankEntity

@Dao
interface BankDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertBank(bank: BankEntity)

    @Delete
    suspend fun deleteBank(bank: BankEntity)

    @Query("DELETE FROM BANKS WHERE id=:id")
    suspend fun deleteBank(id: String)

    @Query("SELECT * FROM BANKS")
    fun getAllBanks(): LiveData<List<BankEntity>>

    @Query("SELECT * FROM BANKS WHERE id=:id")
    suspend fun getBank(id: String): BankEntity?
}