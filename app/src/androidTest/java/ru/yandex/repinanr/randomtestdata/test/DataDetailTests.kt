package ru.yandex.repinanr.ui.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.yandex.repinanr.movies.ui.util.app
import ru.yandex.repinanr.randomtestdata.presentation.activity.MainActivity

@RunWith(AndroidJUnit4::class)
@LargeTest
class DataDetailTests {

    @get : Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSaveButtonDisabledAfterSave() {
        app {
            chooserScreen {
                clickOnItem(USER.ordinal)
            }
            dataDetailScreen {
                waitForDataLoad()
                checkSaveButton(true)
                clickSaveButton()
                checkSaveButton(false)
            }
        }
    }

    @Test
    fun testUserDataOpen() {
        app {
            chooserScreen {
                clickOnItem(USER.ordinal)
            }
            dataDetailScreen {
                waitForDataLoad()
                checkTitleText(USER.title)
            }
        }
    }

    @Test
    fun testBankDataOpen() {
        app {
            chooserScreen {
                clickOnItem(BANK.ordinal)
            }
            dataDetailScreen {
                waitForDataLoad()
                checkTitleText(BANK.title)
            }
        }
    }

    @Test
    fun testCreditCardDataOpen() {
        app {
            chooserScreen {
                clickOnItem(CREDIT_CARD.ordinal)
            }
            dataDetailScreen {
                waitForDataLoad()
                checkTitleText(CREDIT_CARD.title)
            }
        }
    }

    @Test
    fun testAddressDataOpen() {
        app {
            chooserScreen {
                clickOnItem(ADDRESS.ordinal)
            }
            dataDetailScreen {
                waitForDataLoad()
                checkTitleText(ADDRESS.title)
            }
        }
    }
}