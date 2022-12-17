package ru.yandex.repinanr.data.room.address

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.data.model.address.AddressEntity

@Dao
interface AddressDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAddress(address: AddressEntity)

    @Query("DELETE FROM ADDRESSES WHERE id=:id")
    suspend fun deleteAddress(id: Long)

    @Query("SELECT * FROM ADDRESSES")
    suspend fun getAllAddresses(): List<AddressEntity>

    @Query("SELECT * FROM ADDRESSES WHERE id=:id")
    suspend fun getAddress(id: Long): AddressEntity?
}