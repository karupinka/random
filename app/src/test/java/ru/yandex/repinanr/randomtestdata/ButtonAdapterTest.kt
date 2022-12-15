package ru.yandex.repinanr.randomtestdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ButtonAdapter
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ButtonItem
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.*

@RunWith(RobolectricTestRunner::class)
class ButtonAdapterTest {
    private lateinit var adapter: ButtonAdapter

    @Before
    fun setUp() {
        adapter = ButtonAdapter()
    }

    @Test
    fun itemCount() {
        adapter.submitList(listOf(getButtonItem(), getButtonItem()))
        assertEquals(adapter.itemCount, 2)
    }

    @Test
    fun itemType() {
        adapter.submitList(listOf(getButtonItem()))
        assertEquals(adapter.getItemViewType(0), 0)
    }

    companion object {
        fun getButtonItem() = ButtonItem(
            R.string.user_title,
            R.drawable.ic_user,
            Datas.USER
        )
    }
}