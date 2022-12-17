package ru.yandex.repinanr.dictionary.di

import dagger.Binds
import dagger.Module
import ru.yandex.repinanr.di.ApplicationScope
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepositoryImpl

@Module
interface RepositoryModule {
    @Binds
    @ApplicationScope
    fun bindRepository(repositoryImpl: RandomDataRepositoryImpl): RandomDataRepository
}