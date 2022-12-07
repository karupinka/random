package ru.yandex.repinanr.randomtestdata.data.room.address

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.randomtestdata.data.model.address.AddressEntity

@Dao
interface AddressDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAddress(address: AddressEntity)

    @Delete
    suspend fun deleteAddress(address: AddressEntity)

    @Query("DELETE FROM ADDRESSES WHERE id=:id")
    suspend fun deleteAddress(id: String)

    @Query("SELECT * FROM ADDRESSES")
    fun getAllAddresses(): LiveData<List<AddressEntity>>

    @Query("SELECT * FROM ADDRESSES WHERE id=:id")
    suspend fun getAddress(id: String): AddressEntity?
}