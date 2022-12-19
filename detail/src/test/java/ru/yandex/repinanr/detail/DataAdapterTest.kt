package ru.yandex.repinanr.detail

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.yandex.repinanr.detail.presentation.DataAdapter
import ru.yandex.repinanr.detail.presentation.DataItemModel

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