package ru.yandex.repinanr.randomtestdata.presentation.save.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.domain.model.*
import javax.inject.Inject

class SaveDataAdapter @Inject constructor() : ListAdapter<DataModel, SaveViewHolder>(
    DataItemDiffUtilCallback()
) {
    private lateinit var listener: SaveDataListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
        val layout = when (viewType) {
            TYPE_ADDRESS, TYPE_BANK, TYPE_CREDIT_CARD, TYPE_USER -> R.layout.save_item
            else -> throw ClassNotFoundException("Class $viewType is not supported")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return SaveViewHolder(view)
    }

    override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener, position)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is AddressModel -> TYPE_ADDRESS
            is BankModel -> TYPE_BANK
            is CreditCardModel -> TYPE_CREDIT_CARD
            is UserModel -> TYPE_USER
            else -> throw ClassNotFoundException("Class ${item.javaClass} is not supported")
        }
    }

    fun setListener(listener: SaveDataListener) {
        this.listener = listener
    }

    companion object {
        private const val TYPE_ADDRESS = 0
        private const val TYPE_BANK = 1
        private const val TYPE_CREDIT_CARD = 2
        private const val TYPE_USER = 3
    }
}