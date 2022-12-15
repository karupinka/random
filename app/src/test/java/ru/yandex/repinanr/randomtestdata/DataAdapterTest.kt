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
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataAdapter
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataItemModel
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataListener
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataViewHolder

@RunWith(RobolectricTestRunner::class)
class DataAdapterTest {
    private lateinit var adapter: DataAdapter

    @Before
    fun setUp() {
        adapter = DataAdapter()
    }

    @Test
    fun itemCount() {
        adapter.submitList(listOf(getDataItem(), getDataItem(), getDataItem()))
        assertEquals(adapter.itemCount, 3)
    }

    @Test
    fun itemType() {
        adapter.submitList(listOf(getDataItem()))
        assertEquals(adapter.getItemViewType(0), 0)
    }

    companion object {
        fun getDataItem() = DataItemModel(
            R.string.address_title,
            "Address title"
        )
    }
}