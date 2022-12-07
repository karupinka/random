package ru.yandex.repinanr.randomtestdata.data.room.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.randomtestdata.data.model.user.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("DELETE FROM USERS WHERE id=:id")
    suspend fun deleteUser(id: String)

    @Query("SELECT * FROM USERS")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM USERS WHERE id=:id")
    suspend fun getUser(id: String): UserEntity?
}