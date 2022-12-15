package ru.yandex.repinanr.randomtestdata.presentation.save.address

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.yandex.repinanr.randomtestdata.data.model.common.DataModel
import ru.yandex.repinanr.randomtestdata.domain.usecases.address.DeleteSaveAddressUseCase
import ru.yandex.repinanr.randomtestdata.domain.usecases.address.GetSaveAddressesUseCase
import ru.yandex.repinanr.randomtestdata.presentation.save.common.*
import javax.inject.Inject

class SaveAddressViewModel @Inject constructor(
    private val getSaveAddressesUseCase: GetSaveAddressesUseCase,
    private val deleteSaveAddressUseCase: DeleteSaveAddressUseCase
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

    fun getSaveAddresses() {
        _state.value = InProgress
        viewModelScope.launch(errorStateHandlerException) {
            val list = getSaveAddressesUseCase()
            if (list.isEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
                _dataList.value = list
            }
        }
    }

    fun deleteAddress(id: Long) {
        viewModelScope.launch(errorStateHandlerException) {
            deleteSaveAddressUseCase(id)
            _dataList.value = _dataList.value?.filter { it.id != id }
            if (_dataList.value.isNullOrEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
            }
        }
    }
}