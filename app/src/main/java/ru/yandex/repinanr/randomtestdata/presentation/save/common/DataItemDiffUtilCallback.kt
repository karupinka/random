package ru.yandex.repinanr.randomtestdata.presentation.save.common

import androidx.recyclerview.widget.DiffUtil
import ru.yandex.repinanr.randomtestdata.data.model.common.DataModel

class DataItemDiffUtilCallback: DiffUtil.ItemCallback<DataModel>() {
    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }
}