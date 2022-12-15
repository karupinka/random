package ru.yandex.repinanr.randomtestdata.app

import android.app.Application
import ru.yandex.repinanr.randomtestdata.di.DaggerApplicationComponent

class App : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
