package ru.yandex.repinanr.save.di

import dagger.Module
import dagger.Provides
import ru.yandex.repinanr.save.presentation.common.SaveDataAdapter

@Module
class SaveAdapterModule {

    @Provides
    fun provideSaveDataAdapter() = SaveDataAdapter()
}