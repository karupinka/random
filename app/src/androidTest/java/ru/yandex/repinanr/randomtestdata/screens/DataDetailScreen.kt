package ru.yandex.repinanr.movies.ui.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.not
import ru.yandex.repinanr.movies.ui.util.TextActions.getText
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists.waitForView
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists.waitForViewClickable
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists.waitUntilViewGone
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.presentation.activity.MainActivity
import ru.yandex.repinanr.randomtestdata.util.ToastMatcher

class DataDetailScreen {
    fun waitForScreen() = waitForView(R.id.data_recycler_view)

    fun waitForDataLoad() = waitForView(R.id.data_recycler_view, checkVisibility = true)

    fun getTitleText(): String {
        return getText(onView(withId(R.id.data_title)))
    }

    fun checkTitleText(text: String) {
        onView(withId(R.id.data_title)).check(matches(withText(text)))
    }

    fun clickSaveButton() {
        onView(withId(R.id.save_floating)).perform(click())
    }

    fun checkSaveButton(isEnabled: Boolean) {
        if (isEnabled) {
            onView(withId(R.id.save_floating)).check(matches(isEnabled()))
        } else {
            onView(withId(R.id.save_floating)).check(matches(not(isEnabled())))
        }
    }

    fun assertToast(text: String) {
        onView(withText(text)).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    fun pressBack() {
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}