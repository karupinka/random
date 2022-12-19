package ru.yandex.repinanr.randomtestdata.di

import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.domain.repository.RandomDataRepositoryImpl
import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun bindRepository(repositoryImpl: RandomDataRepositoryImpl): RandomDataRepository =
        repositoryImpl
}