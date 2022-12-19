package ru.yandex.repinanr.randomtestdata.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.yandex.repinanr.di.AdapterModule
import ru.yandex.repinanr.dictionary.di.DataModule
import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ChooseFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        AdapterModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: ChooseFragment)

    fun getRepository(): RandomDataRepository

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}