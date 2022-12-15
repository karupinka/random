package ru.yandex.repinanr.randomtestdata.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataViewModel
import ru.yandex.repinanr.randomtestdata.presentation.save.address.SaveAddressViewModel
import ru.yandex.repinanr.randomtestdata.presentation.save.bank.SaveBankViewModel
import ru.yandex.repinanr.randomtestdata.presentation.save.card.SaveCreditCardViewModel
import ru.yandex.repinanr.randomtestdata.presentation.save.user.SaveUserViewModel

@Module
interface ViewModelModule {

    @Binds
    fun bindsBankViewModel(model: DataViewModel): ViewModel

    @Binds
    fun bindsSaveUserViewModel(model: SaveUserViewModel): ViewModel

    @Binds
    fun bindsSaveBankViewModel(model: SaveBankViewModel): ViewModel

    @Binds
    fun bindsSaveAddressViewModel(model: SaveAddressViewModel): ViewModel

    @Binds
    fun bindsSaveCreditCardViewModel(model: SaveCreditCardViewModel): ViewModel
}