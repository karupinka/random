package ru.yandex.repinanr.movies.ui.util

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import ru.yandex.repinanr.movies.ui.screens.ChooserScreen
import ru.yandex.repinanr.movies.ui.screens.DataDetailScreen
import ru.yandex.repinanr.movies.ui.screens.SaveDataScreen
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists.waitForActivity
import ru.yandex.repinanr.randomtestdata.R

fun app(func: App.() -> Unit) = App().apply {
    waitForActivity(InstrumentationRegistry.getInstrumentation())
    func()
}

class App {

    fun chooserScreen(func: ChooserScreen.() -> Unit = {}) = ChooserScreen().apply {
        waitForForm()
        func()
    }

    fun dataDetailScreen(func: DataDetailScreen.() -> Unit = {}) = DataDetailScreen().apply {
        waitForScreen()
        func()
    }

    fun saveDataScreen(func: SaveDataScreen.() -> Unit = {}) =
        SaveDataScreen().apply {
            waitForForm()
            func()
        }

    fun openSaveData(func: SaveDataScreen.() -> Unit) = SaveDataScreen().apply {
        onView(withId(R.id.saveChooseFragment)).perform(click())
        waitForForm()
        func()
    }
}