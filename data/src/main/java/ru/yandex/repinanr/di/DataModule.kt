package ru.yandex.repinanr.dictionary.di

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.data.remote.ApiClient
import ru.yandex.repinanr.data.remote.RandomDataService
import ru.yandex.repinanr.data.room.RandomDataDb
import ru.yandex.repinanr.data.room.address.AddressDao
import ru.yandex.repinanr.data.room.bank.BankDao
import ru.yandex.repinanr.data.room.card.CardDao
import ru.yandex.repinanr.data.room.user.UserDao
import ru.yandex.repinanr.di.ApplicationScope
import javax.inject.Singleton

@Module
interface DataModule {

    companion object {
        @Provides
        @Singleton
        fun bindService(): RandomDataService {
            return ApiClient.apiService
        }

        @Provides
        @Singleton
        fun provideAppDb(application: Application): RandomDataDb {
            return RandomDataDb.getInstance(application)
        }

        @Provides
        @Singleton
        fun bindUserDao(application: Application): UserDao {
            return RandomDataDb.getInstance(application).getUserDao()
        }

        @Provides
        @Singleton
        fun bindCreditCardDao(application: Application): CardDao {
            return RandomDataDb.getInstance(application).getCreditCardDao()
        }

        @Provides
        @Singleton
        fun bindBankDao(application: Application): BankDao {
            return RandomDataDb.getInstance(application).getBankDao()
        }

        @Provides
        @Singleton
        fun bindAddressDao(application: Application): AddressDao {
            return RandomDataDb.getInstance(application).getAddressDao()
        }
    }
}