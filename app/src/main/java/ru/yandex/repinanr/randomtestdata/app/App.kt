package ru.yandex.repinanr.randomtestdata.app

import android.app.Application
import ru.yandex.repinanr.randomtestdata.di.DaggerApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}
