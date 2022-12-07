package ru.yandex.repinanr.dictionary.di

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.randomtestdata.data.remote.ApiClient
import ru.yandex.repinanr.randomtestdata.data.remote.RandomDataService
import ru.yandex.repinanr.randomtestdata.data.room.RandomDataDb
import ru.yandex.repinanr.randomtestdata.data.room.address.AddressDao
import ru.yandex.repinanr.randomtestdata.data.room.bank.BankDao
import ru.yandex.repinanr.randomtestdata.data.room.card.CardDao
import ru.yandex.repinanr.randomtestdata.data.room.user.UserDao

@Module
interface DataModule {

    companion object {
        @Provides
        @ApplicationScope
        fun bindService(): RandomDataService {
            return ApiClient.apiService
        }

        @Provides
        @ApplicationScope
        fun bindUserDao(application: Application): UserDao {
            return RandomDataDb.getInstance(application).getUserDao()
        }

        @Provides
        @ApplicationScope
        fun bindCreditCardDao(application: Application): CardDao {
            return RandomDataDb.getInstance(application).getCreditCardDao()
        }

        @Provides
        @ApplicationScope
        fun bindBankDao(application: Application): BankDao {
            return RandomDataDb.getInstance(application).getBankDao()
        }

        @Provides
        @ApplicationScope
        fun bindAddressDao(application: Application): AddressDao {
            return RandomDataDb.getInstance(application).getAddressDao()
        }
    }
}