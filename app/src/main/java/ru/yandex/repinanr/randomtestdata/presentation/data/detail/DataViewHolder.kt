package ru.yandex.repinanr.randomtestdata.presentation.data.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.databinding.TextInfoItemBinding

class DataViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var binding: TextInfoItemBinding

    private fun bindItem(item: DataItemModel, listener: DataListener) {
        binding = TextInfoItemBinding.bind(itemView)

        with(binding) {
            title.text = itemView.context.getString(item.title)
            subtitle.text = item.subtitle
            dataCopy.setImageResource(R.drawable.ic_content_copy)

            subtitle.setOnClickListener {
                listener.onCopyClickListener(item.subtitle)
            }
            dataCopy.setOnClickListener {
                listener.onCopyClickListener(item.subtitle)
            }
        }
    }

    fun bind(item: DataItemModel, listener: DataListener) {
        bindItem(item, listener)
    }
}