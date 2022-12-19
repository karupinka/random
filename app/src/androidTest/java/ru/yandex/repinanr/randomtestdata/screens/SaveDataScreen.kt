package ru.yandex.repinanr.ui.screens

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists
import ru.yandex.repinanr.randomtestdata.R

class SaveDataScreen {
    fun waitForForm() = WaitUntilViewExists.waitForView(R.id.tab_layout)

    fun removeItem(text: String) {
        onView(
            allOf(
                withId(R.id.remove),
                withParent(
                    allOf(
                        instanceOf(ConstraintLayout::class.java),
                        withChild(withText(text))
                    )
                )
            )
        )
            .perform(click())
    }
}