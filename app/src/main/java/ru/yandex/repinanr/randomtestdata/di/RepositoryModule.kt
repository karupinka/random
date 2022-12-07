package ru.yandex.repinanr.dictionary.di

import dagger.Binds
import dagger.Module
import ru.yandex.repinanr.randomtestdata.data.repository.RandomDataRepositoryImpl
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository

@Module
interface RepositoryModule {
    @Binds
    @ApplicationScope
    fun bindRepository(repositoryImpl: RandomDataRepositoryImpl): RandomDataRepository
}