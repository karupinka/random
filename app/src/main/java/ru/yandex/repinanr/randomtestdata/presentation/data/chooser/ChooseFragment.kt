package ru.yandex.repinanr.randomtestdata.presentation.data.chooser

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.app.App
import ru.yandex.repinanr.randomtestdata.databinding.FragmentChooseBinding
import javax.inject.Inject

class ChooseFragment : Fragment() {
    private lateinit var binding: FragmentChooseBinding
    private val buttons = listOf(
        ButtonItem(
            R.string.user_title,
            R.drawable.ic_user,
            Datas.USER
        ),
        ButtonItem(
            R.string.bank_title,
            R.drawable.ic_bank,
            Datas.BANK
        ),
        ButtonItem(
            R.string.address_title,
            R.drawable.ic_home,
            Datas.ADDRESS
        ),
        ButtonItem(
            R.string.credit_card_title,
            R.drawable.ic_credit_card,
            Datas.CREDIT_CARD
        )
    )

    @Inject
    lateinit var adapter: ButtonAdapter

    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        adapter.submitList(buttons)
        binding.chooseRecycler.adapter = adapter
        binding.chooseRecycler.layoutManager = LinearLayoutManager(this@ChooseFragment.context)
    }
}