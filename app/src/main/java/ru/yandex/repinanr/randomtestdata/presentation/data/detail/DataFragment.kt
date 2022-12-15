package ru.yandex.repinanr.randomtestdata.presentation.data.detail

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ru.yandex.repinanr.randomtestdata.R
import ru.yandex.repinanr.randomtestdata.app.App
import ru.yandex.repinanr.randomtestdata.databinding.FragmentDataBinding
import javax.inject.Inject
import kotlin.Error

class DataFragment : Fragment() {
    private lateinit var binding: FragmentDataBinding
    private val args by navArgs<DataFragmentArgs>()

    @Inject
    lateinit var adapter: DataAdapter

    @Inject
    lateinit var viewModel: DataViewModel

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
        binding = FragmentDataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData(args.id, args.type)
        binding.dataTitle.setText(args.type.title)
        initAdapter()
        observeState()
        observeSaveState()
        binding.saveFloating.setOnClickListener {
            viewModel.saveData(args.id)
        }
        binding.retryButton.setOnClickListener {
            viewModel.getData(args.id, args.type)
        }
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is InProgress -> {
                    showProgress(withData = false)
                }
                is Error -> {
                    showError(R.string.something_error)
                }
                is InternetError -> {
                    showError(R.string.internet_error, R.drawable.ic_no_internet)
                }
                is HttpError -> {
                    showError(R.string.server_error)
                }
                is ResultList -> {
                    showStateResult(it)
                }
                else -> {
                    throw ClassCastException()
                }
            }
        }
    }

    private fun observeSaveState() {
        viewModel.saveState.observe(viewLifecycleOwner) {
            when (it) {
                is SaveProgress -> {
                    showProgress(withData = true)
                }
                is SaveError -> {
                    showSaveError()
                }
                is SaveResult -> {
                    showSaveResult()
                }
                else -> {
                    throw ClassCastException()
                }
            }
        }
    }

    private fun showError(
        @StringRes message: Int,
        @DrawableRes icon: Int = R.drawable.ic_error_40
    ) {
        with(binding) {
            progressBar.visibility = View.GONE
            saveFloating.visibility = View.GONE
            errorDataLayout.visibility = View.VISIBLE
            errorTitle.setText(message)
            errorIcon.setImageResource(icon)
        }
    }

    private fun showSaveError() {
        with(binding) {
            progressBar.visibility = View.GONE
            dataRecyclerView.visibility = View.VISIBLE
            errorDataLayout.visibility = View.GONE
        }
        showSnackbar(R.string.save_no_success)
    }

    private fun showSaveResult() {
        with(binding) {
            progressBar.visibility = View.GONE
            dataRecyclerView.visibility = View.VISIBLE
            saveFloating.visibility = View.VISIBLE
            saveFloating.isEnabled = false
            errorDataLayout.visibility = View.GONE
        }
        showSnackbar(R.string.save_success)
    }

    private fun showSnackbar(@StringRes text: Int) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_LONG).show()
    }

    private fun showProgress(withData: Boolean) {
        with(binding) {
            progressBar.visibility = View.VISIBLE
            if (!withData) {
                dataRecyclerView.visibility = View.GONE
                saveFloating.visibility = View.GONE
            }
            errorDataLayout.visibility = View.GONE
        }
    }

    private fun showStateResult(result: ResultList) {
        with(binding) {
            progressBar.visibility = View.GONE
            saveFloating.visibility =
                if (args.id == DataViewModel.DEFAULT_ARG) View.VISIBLE else View.GONE
            dataRecyclerView.visibility = View.VISIBLE
            errorDataLayout.visibility = View.GONE
            adapter.submitList(result.list)
        }
    }

    private fun setCopyClickListener(value: String) {
        createClipBoard(value)
        showSnackbar(R.string.copied)
    }

    private fun createClipBoard(copyString: String) {
        val clipboard: ClipboardManager? =
            activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("simple text", copyString)
        clipboard?.setPrimaryClip(clip)
    }

    private fun initAdapter() {
        binding.dataRecyclerView.adapter = adapter
        adapter.setListener(object : DataListener {
            override fun onCopyClickListener(value: String) {
                setCopyClickListener(value)
            }
        })
        binding.dataRecyclerView.layoutManager = LinearLayoutManager(this@DataFragment.context)
    }
}