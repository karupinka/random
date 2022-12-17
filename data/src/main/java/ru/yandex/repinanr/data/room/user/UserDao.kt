package ru.yandex.repinanr.data.room.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.yandex.repinanr.data.model.user.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM USERS WHERE id=:id")
    suspend fun deleteUser(id: Long)

    @Query("SELECT * FROM USERS")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM USERS WHERE id=:id")
    suspend fun getUser(id: Long): UserEntity?
}