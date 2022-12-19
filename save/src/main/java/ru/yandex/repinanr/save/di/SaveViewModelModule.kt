package ru.yandex.repinanr.save.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.yandex.repinanr.save.presentation.address.SaveAddressViewModel
import ru.yandex.repinanr.save.presentation.bank.SaveBankViewModel
import ru.yandex.repinanr.save.presentation.card.SaveCreditCardViewModel
import ru.yandex.repinanr.save.presentation.common.SaveUserViewModel

@Module
interface SaveViewModelModule {

    @Binds
    fun bindsSaveUserViewModel(model: SaveUserViewModel): ViewModel

    @Binds
    fun bindsSaveBankViewModel(model: SaveBankViewModel): ViewModel

    @Binds
    fun bindsSaveAddressViewModel(model: SaveAddressViewModel): ViewModel

    @Binds
    fun bindsSaveCreditCardViewModel(model: SaveCreditCardViewModel): ViewModel
}