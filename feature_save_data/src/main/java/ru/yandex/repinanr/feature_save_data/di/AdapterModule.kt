package ru.yandex.repinanr.dictionary.di

import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ButtonAdapter
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataAdapter
import ru.yandex.repinanr.randomtestdata.presentation.save.common.SaveDataAdapter

@Module
class AdapterModule {
    @Provides
    fun provideButtonAdapter() = ButtonAdapter()

    @Provides
    fun provideSaveDataAdapter() = SaveDataAdapter()

    @Provides
    fun provideDataAdapter() = DataAdapter()
}