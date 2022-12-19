package ru.yandex.repinanr.detail.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import ru.yandex.repinanr.detail.presentation.DataFragment
import ru.yandex.repinanr.di.ApplicationScope
import ru.yandex.repinanr.dictionary.di.DataModule
import ru.yandex.repinanr.randomtestdata.di.ApplicationComponent
import javax.inject.Singleton

@DataScope
@Component(
    modules = [
        DetailAdapterModule::class,
        DetailViewModelModule::class
    ],
    dependencies = [ApplicationComponent::class]
)
interface DataComponent {

    fun inject(fragment: DataFragment)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent
        ): DataComponent
    }
}