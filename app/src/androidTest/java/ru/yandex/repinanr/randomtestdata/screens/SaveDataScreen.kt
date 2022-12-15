package ru.yandex.repinanr.movies.ui.screens

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import ru.yandex.repinanr.movies.ui.util.WaitUntilViewExists
import ru.yandex.repinanr.randomtestdata.R

class SaveDataScreen {
    fun waitForForm() = WaitUntilViewExists.waitForView(R.id.tab_layout)

//    fun assertRecyclerViewDisplayed() {
//        onView(withId(R.id.rc_favorite)).check(matches(isDisplayed()))
//    }
//
//    fun assertItem(position: Int, text: String) {
//        onView(withId(R.id.rc_favorite))
//            .check(matches(atPosition(position, hasDescendant(withText(text)))))
//    }

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