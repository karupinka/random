package ru.yandex.repinanr.randomtestdata.presentation.data.detail

import androidx.recyclerview.widget.DiffUtil

class DataItemDiffUtilCallback: DiffUtil.ItemCallback<DataItemModel>() {
    override fun areItemsTheSame(oldItem: DataItemModel, newItem: DataItemModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: DataItemModel, newItem: DataItemModel): Boolean {
        return oldItem == newItem
    }
}