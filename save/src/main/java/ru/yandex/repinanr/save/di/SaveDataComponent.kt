package ru.yandex.repinanr.save.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.yandex.repinanr.di.ApplicationScope
import ru.yandex.repinanr.dictionary.di.DataModule
import ru.yandex.repinanr.randomtestdata.di.ApplicationComponent
import ru.yandex.repinanr.save.presentation.address.SaveAddressFragment
import ru.yandex.repinanr.save.presentation.bank.SaveBankFragment
import ru.yandex.repinanr.save.presentation.card.SaveCreditCardFragment
import ru.yandex.repinanr.save.presentation.common.SaveUserFragment

@SaveDataScope
@Component(
    modules = [
        SaveAdapterModule::class,
        SaveViewModelModule::class
    ],
    dependencies = [ApplicationComponent::class]
)
interface SaveDataComponent {

    fun inject(fragment: SaveCreditCardFragment)

    fun inject(fragment: SaveBankFragment)

    fun inject(fragment: SaveAddressFragment)

    fun inject(fragment: SaveUserFragment)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent
        ): SaveDataComponent
    }
}