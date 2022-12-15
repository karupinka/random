package ru.yandex.repinanr.randomtestdata.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.yandex.repinanr.dictionary.di.AdapterModule
import ru.yandex.repinanr.dictionary.di.ApplicationScope
import ru.yandex.repinanr.dictionary.di.DataModule
import ru.yandex.repinanr.dictionary.di.RepositoryModule
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ChooseFragment
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.address.SaveAddressFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.bank.SaveBankFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.card.SaveCreditCardFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.user.SaveUserFragment

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        RepositoryModule::class,
        AdapterModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: ChooseFragment)

    fun inject(fragment: DataFragment)

    fun inject(fragment: SaveCreditCardFragment)

    fun inject(fragment: SaveBankFragment)

    fun inject(fragment: SaveAddressFragment)

    fun inject(fragment: SaveUserFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}