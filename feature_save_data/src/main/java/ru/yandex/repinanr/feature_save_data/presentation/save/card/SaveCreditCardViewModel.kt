package ru.yandex.repinanr.randomtestdata.presentation.save.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.yandex.repinanr.randomtestdata.domain.model.DataModel
import ru.yandex.repinanr.randomtestdata.domain.usecases.card.DeleteSaveCreditCardUseCase
import ru.yandex.repinanr.randomtestdata.domain.usecases.card.GetSaveCraditCardsUseCase
import ru.yandex.repinanr.randomtestdata.presentation.save.common.*
import javax.inject.Inject

class SaveCreditCardViewModel @Inject constructor(
    private val getSaveCreditCardsUseCase: GetSaveCraditCardsUseCase,
    private val deleteSaveCreditCardUseCase: DeleteSaveCreditCardUseCase
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

    fun getSaveCreditCards() {
        _state.value = InProgress
        viewModelScope.launch(errorStateHandlerException) {
            val list = getSaveCreditCardsUseCase()
            if (list.isEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
                _dataList.value = list
            }
        }
    }

    fun deleteCreditCard(id: Long) {
        viewModelScope.launch(errorStateHandlerException) {
            deleteSaveCreditCardUseCase(id)
            _dataList.value = _dataList.value?.filter { it.id != id }
            if (_dataList.value.isNullOrEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
            }
        }
    }
}