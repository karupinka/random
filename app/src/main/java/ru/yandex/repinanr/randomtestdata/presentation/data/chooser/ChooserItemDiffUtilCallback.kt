package ru.yandex.repinanr.randomtestdata.presentation.data.chooser

import androidx.recyclerview.widget.DiffUtil

class ChooserItemDiffUtilCallback: DiffUtil.ItemCallback<ButtonItem>() {
    override fun areItemsTheSame(oldItem: ButtonItem, newItem: ButtonItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ButtonItem, newItem: ButtonItem): Boolean {
        return oldItem == newItem
    }
}