package ru.yandex.repinanr.randomtestdata.presentation.data.chooser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.yandex.repinanr.randomtestdata.R
import javax.inject.Inject

class ButtonAdapter @Inject constructor() : ListAdapter<ButtonItem, ButtonViewHolder>(
    ChooserItemDiffUtilCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val layout = when (viewType) {
            TYPE_BUTTON -> R.layout.button_item
            else -> throw ClassNotFoundException("Class $viewType is not supported")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ButtonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is ButtonItem -> TYPE_BUTTON
            else -> throw ClassNotFoundException("Class ${item.javaClass} is not supported")
        }
    }

    companion object {
        private const val TYPE_BUTTON = 0
    }
}