package ru.yandex.repinanr.detail.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import ru.yandex.repinanr.detail.presentation.DataViewModel

@Module
interface DetailViewModelModule {

    @Binds
    fun bindsViewModel(model: DataViewModel): ViewModel
}