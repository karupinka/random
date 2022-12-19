package ru.yandex.repinanr.save.presentation.common

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.yandex.repinanr.detail.presentation.Datas
import ru.yandex.repinanr.save.databinding.SaveItemBinding
import ru.yandex.repinanr.domain.model.*
import ru.yandex.repinanr.randomtestdata.presentation.data.chooser.ChooseFragmentDirections
import ru.yandex.repinanr.save.R

class SaveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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
            val bundle = bundleOf(
                "type" to Datas.ADDRESS.ordinal,
                "id" to item.id
            )
            itemView.findNavController()
                .navigate(
                    R.id.action_saveChooseFragment_to_dataFragment,
                    bundle
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
            val bundle = bundleOf(
                "type" to Datas.CREDIT_CARD.ordinal,
                "id" to item.id
            )
            itemView.findNavController()
                .navigate(
                    R.id.action_saveChooseFragment_to_dataFragment,
                    bundle
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
            val bundle = bundleOf(
                "type" to Datas.USER.ordinal,
                "id" to item.id
            )
            itemView.findNavController()
                .navigate(
                    R.id.action_saveChooseFragment_to_dataFragment,
                    bundle
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
            val bundle = bundleOf(
                "type" to Datas.BANK.ordinal,
                "id" to item.id
            )
            itemView.findNavController()
                .navigate(
                    R.id.action_saveChooseFragment_to_dataFragment,
                    bundle
                )
        }
    }
}