package ru.yandex.repinanr.randomtestdata.di

import dagger.Component
import ru.yandex.repinanr.dictionary.di.DataModule
import ru.yandex.repinanr.dictionary.di.RepositoryModule

@Component(
    modules = [
        DataModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {
}