package ru.yandex.repinanr.randomtestdata.presentation.data.chooser

import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.databinding.ButtonItemBinding

class ButtonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var binding: ButtonItemBinding

    private fun bindItem(buttonItem: ButtonItem, position: Int) {
        binding = ButtonItemBinding.bind(itemView)

        with(binding) {
            title.text = itemView.context.getString(buttonItem.title)
            buttonIcon.setImageResource(buttonItem.drawable)

            val csl = AppCompatResources.getColorStateList(itemView.context, R.color.gray)
            buttonIcon.imageTintList = csl
        }

        itemView.setOnClickListener {
            itemView.findNavController()
                .navigate(ChooseFragmentDirections
                    .actionChooseFragmentToDataFragment(buttonItem.type)
                )
        }
    }

    fun bind(buttonItem: ButtonItem?, position: Int) {
        buttonItem?.let {
            bindItem(it, position)
        }
    }
}