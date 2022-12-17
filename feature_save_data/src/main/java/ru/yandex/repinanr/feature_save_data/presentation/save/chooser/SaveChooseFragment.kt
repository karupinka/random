package ru.yandex.repinanr.randomtestdata.presentation.save.chooser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.databinding.FragmentSaveChooseBinding
import ru.yandex.repinanr.randomtestdata.presentation.save.address.SaveAddressFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.bank.SaveBankFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.card.SaveCreditCardFragment
import ru.yandex.repinanr.randomtestdata.presentation.save.user.SaveUserFragment

class SaveChooseFragment : Fragment() {
    private lateinit var binding: FragmentSaveChooseBinding
    private var adapter: SaveChooserCollectionAdapter? = null
    private val tabTitles = listOf(
        R.string.user_tab,
        R.string.bank_tab,
        R.string.address_tab,
        R.string.credit_card_tab
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaveChooseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments = arrayListOf(
            SaveUserFragment(),
            SaveBankFragment(),
            SaveAddressFragment(),
            SaveCreditCardFragment()
        )
        adapter = SaveChooserCollectionAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.pager.isSaveEnabled = false
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = getText(tabTitles[position])
        }.attach()
    }
}