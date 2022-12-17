package ru.yandex.repinanr.randomtestdata.presentation.save.common

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.yandex.repinanr.randomtestdata.databinding.SaveItemBinding
import ru.yandex.repinanr.randomtestdata.domain.model.*
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.Datas
import ru.yandex.repinanr.randomtestdata.presentation.save.chooser.SaveChooseFragmentDirections

class SaveViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var binding: SaveItemBinding

    fun bind(item: DataModel, listener: SaveDataListener, position: Int) {
        when (item) {
            is AddressModel -> bindAddressItem(item, listener, position)
            is BankModel -> bindBankItem(item, listener, position)
            is CreditCardModel -> bindCreditCardItem(item, listener, position)
            is UserModel -> bindUserItem(item, listener, position)
        }
    }

    private fun bindAddressItem(item: AddressModel, listener: SaveDataListener, position: Int) {
        binding = SaveItemBinding.bind(itemView)

        with(binding) {
            saveTitle.text = item.fullAddress
            rowIndexKey.text = "${position + 1}"
            remove.setOnClickListener {
                listener.onRemoveClickListener(item.id)
            }
        }

        itemView.setOnClickListener {
            itemView.findNavController()
                .navigate(
                    SaveChooseFragmentDirections.actionSaveChooseFragmentToDataFragment(Datas.ADDRESS)
                        .setId(item.id)
                )
        }
    }

    private fun bindCreditCardItem(
        item: CreditCardModel,
        listener: SaveDataListener,
        position: Int
    ) {
        binding = SaveItemBinding.bind(itemView)

        with(binding) {
            saveTitle.text = item.number
            rowIndexKey.text = "${position + 1}"
            remove.setOnClickListener {
                listener.onRemoveClickListener(item.id)
            }
        }

        itemView.setOnClickListener {
            itemView.findNavController()
                .navigate(
                    SaveChooseFragmentDirections.actionSaveChooseFragmentToDataFragment(Datas.CREDIT_CARD)
                        .setId(item.id)
                )
        }
    }

    private fun bindUserItem(item: UserModel, listener: SaveDataListener, position: Int) {
        binding = SaveItemBinding.bind(itemView)

        with(binding) {
            saveTitle.text = "${item.firstName} ${item.lastName}"
            rowIndexKey.text = "${position + 1}"
            remove.setOnClickListener {
                listener.onRemoveClickListener(item.id)
            }
        }

        itemView.setOnClickListener {
            itemView.findNavController()
                .navigate(
                    SaveChooseFragmentDirections.actionSaveChooseFragmentToDataFragment(Datas.USER)
                        .setId(item.id)
                )
        }
    }

    private fun bindBankItem(item: BankModel, listener: SaveDataListener, position: Int) {
        binding = SaveItemBinding.bind(itemView)

        with(binding) {
            saveTitle.text = item.bankName
            rowIndexKey.text = "${position + 1}"
            remove.setOnClickListener {
                listener.onRemoveClickListener(item.id)
            }
        }

        itemView.setOnClickListener {
            itemView.findNavController()
                .navigate(
                    SaveChooseFragmentDirections.actionSaveChooseFragmentToDataFragment(Datas.BANK)
                        .setId(item.id)
                )
        }
    }
}