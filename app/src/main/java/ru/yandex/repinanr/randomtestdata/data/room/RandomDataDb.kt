package ru.yandex.repinanr.randomtestdata.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.yandex.repinanr.randomtestdata.data.model.address.AddressEntity
import ru.yandex.repinanr.randomtestdata.data.model.bank.BankEntity
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardEntity
import ru.yandex.repinanr.randomtestdata.data.model.user.UserEntity
import ru.yandex.repinanr.randomtestdata.data.room.address.AddressDao
import ru.yandex.repinanr.randomtestdata.data.room.bank.BankDao
import ru.yandex.repinanr.randomtestdata.data.room.card.CardDao
import ru.yandex.repinanr.randomtestdata.data.room.user.UserDao

@Database(
    entities = [
        UserEntity::class,
        CreditCardEntity::class,
        AddressEntity::class,
        BankEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RandomDataDb : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getCreditCardDao(): CardDao

    abstract fun getBankDao(): BankDao

    abstract fun getAddressDao(): AddressDao

    companion object {
        private var DB: RandomDataDb? = null
        private val LOCK = Any()
        private val DATABASE_NAME = "db-word.db"

        fun getInstance(context: Context): RandomDataDb {
            DB?.let { return it }
            val instance = Room.databaseBuilder(
                context,
                RandomDataDb::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
            DB = instance
            return instance
        }
    }
}