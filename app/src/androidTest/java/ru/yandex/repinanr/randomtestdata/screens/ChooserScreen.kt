package ru.yandex.repinanr.ui.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import ru.yandex.repinanr.movies.ui.util.RecyclerViewMatcher.atPosition
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ButtonViewHolder

class ChooserScreen {
    fun waitForForm() = WaitUntilViewExists.waitForView(R.id.choose_recycler)

    fun assertRecyclerViewDisplayed() {
        Espresso.onView(withId(R.id.choose_recycler)).check(matches(isDisplayed()))
    }

    fun scrollToItem(position: Int) {
        Espresso.onView(withId(R.id.choose_recycler))
            .perform(RecyclerViewActions.scrollToPosition<ButtonViewHolder>(position))
    }

    fun clickOnItem(position: Int) {
        Espresso.onView(withId(R.id.choose_recycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ButtonViewHolder>(
                    position,
                    click()
                )
            )
    }

    fun assertItem(position: Int, text: String) {
        Espresso.onView(withId(R.id.choose_recycler))
            .check(
                matches(
                    atPosition(
                        position,
                        ViewMatchers.hasDescendant(ViewMatchers.withText(text))
                    )
                )
            )
    }

    enum class Datas(val title: String) {
        USER("Пользователь"),
        BANK("Банк"),
        ADDRESS("Адрес"),
        CREDIT_CARD("Кредитная карта"),
    }
}