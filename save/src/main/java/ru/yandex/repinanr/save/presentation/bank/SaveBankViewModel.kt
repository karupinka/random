package ru.yandex.repinanr.save.presentation.bank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.yandex.repinanr.domain.model.DataModel
import ru.yandex.repinanr.domain.usecases.bank.DeleteSaveBankUseCase
import ru.yandex.repinanr.domain.usecases.bank.GetSaveBanksUseCase
import ru.yandex.repinanr.save.presentation.common.*
import javax.inject.Inject

class SaveBankViewModel @Inject constructor(
    private val getSaveBanksUseCase: GetSaveBanksUseCase,
    private val deleteSaveBankUseCase: DeleteSaveBankUseCase
) : ViewModel() {
    private val _dataList = MutableLiveData<List<DataModel>>()
    val dataList: LiveData<List<DataModel>>
        get() = _dataList
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    private val errorStateHandlerException = CoroutineExceptionHandler { _, throwable ->
        _state.value = Error
    }

    fun getSaveBanks() {
        _state.value = InProgress
        viewModelScope.launch(errorStateHandlerException) {
            val list = getSaveBanksUseCase()
            if (list.isEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
                _dataList.value = list
            }
        }
    }

    fun deleteBank(id: Long) {
        viewModelScope.launch(errorStateHandlerException) {
            deleteSaveBankUseCase(id)
            _state.value = Result
            _dataList.value = _dataList.value?.filter { it.id != id }
            if (_dataList.value.isNullOrEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
            }
        }
    }
}