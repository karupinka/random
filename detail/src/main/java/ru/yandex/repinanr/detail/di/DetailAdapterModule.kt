package ru.yandex.repinanr.detail.di

import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.detail.presentation.DataAdapter

@Module
class DetailAdapterModule {

    @Provides
    fun provideDataAdapter() = DataAdapter()
}