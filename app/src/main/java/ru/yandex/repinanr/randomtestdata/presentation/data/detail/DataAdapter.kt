package ru.yandex.repinanr.randomtestdata.presentation.data.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.yandex.repinanr.randomtestdata.R
import javax.inject.Inject

class DataAdapter @Inject constructor() : ListAdapter<DataItemModel, DataViewHolder>(
    DataItemDiffUtilCallback()
) {
    private lateinit var listener: DataListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layout = when (viewType) {
            TYPE_DATA -> R.layout.text_info_item
            else -> throw ClassNotFoundException("Class $viewType is not supported")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is DataItemModel -> TYPE_DATA
            else -> throw ClassNotFoundException("Class ${item.javaClass} is not supported")
        }
    }

    fun setListener(listener: DataListener) {
        this.listener = listener
    }

    companion object {
        private const val TYPE_DATA = 0
    }
}