package ru.yandex.repinanr.randomtestdata.presentation.save.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.app.App
import ru.yandex.repinanr.randomtestdata.databinding.FragmentSaveDataBinding
import ru.yandex.repinanr.randomtestdata.presentation.save.common.*
import javax.inject.Inject

class SaveUserFragment : Fragment() {
    private lateinit var binding: FragmentSaveDataBinding

    @Inject
    lateinit var adapter: SaveDataAdapter

    @Inject
    lateinit var viewModel: SaveUserViewModel

    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaveDataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.getSaveUsers()
        binding.repeatButton.setOnClickListener {
            viewModel.getSaveUsers()
        }
        viewModel.dataList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is InProgress -> {
                    with(binding) {
                        saveDataProgress.visibility = View.VISIBLE
                        saveDataRecycler.visibility = View.GONE
                        errorLayout.visibility = View.GONE
                        emptyDataTextView.visibility = View.GONE
                    }
                }
                is Error -> {
                    with(binding) {
                        saveDataProgress.visibility = View.GONE
                        saveDataRecycler.visibility = View.GONE
                        errorLayout.visibility = View.VISIBLE
                        emptyDataTextView.visibility = View.GONE
                    }
                }
                is Result -> {
                    with(binding) {
                        saveDataProgress.visibility = View.GONE
                        saveDataRecycler.visibility = View.VISIBLE
                        errorLayout.visibility = View.GONE
                    }
                }
                is EmptyResult -> {
                    with(binding) {
                        saveDataProgress.visibility = View.GONE
                        saveDataRecycler.visibility = View.GONE
                        errorLayout.visibility = View.GONE
                        emptyDataTextView.visibility = View.VISIBLE
                        adapter.submitList(listOf())
                    }
                }
                else -> {}
            }
        }
    }

    private fun initAdapter() {
        binding.saveDataRecycler.adapter = adapter
        binding.saveDataRecycler.layoutManager = LinearLayoutManager(this@SaveUserFragment.context)
        adapter.setListener(object : SaveDataListener {
            override fun onRemoveClickListener(id: Long) {
                removeUser(id)
            }

        })
    }

    private fun removeUser(id: Long) {
        viewModel.deleteSaveUsers(id)
        val snackbar =
            Snackbar.make(
                binding.root,
                R.string.toast_remove_favorite_text,
                Snackbar.LENGTH_LONG
            )
        snackbar.show()
    }
}