package ru.yandex.repinanr.di

import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ButtonAdapter

@Module
class AdapterModule {
    @Provides
    fun provideButtonAdapter() = ButtonAdapter()
}