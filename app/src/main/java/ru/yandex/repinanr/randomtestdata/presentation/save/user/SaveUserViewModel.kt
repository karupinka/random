package ru.yandex.repinanr.randomtestdata.presentation.save.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.yandex.repinanr.randomtestdata.data.model.common.DataModel
import ru.yandex.repinanr.randomtestdata.domain.usecases.user.DeleteSaveUserUseCase
import ru.yandex.repinanr.randomtestdata.domain.usecases.user.GetSaveUsersUseCase
import ru.yandex.repinanr.randomtestdata.presentation.save.common.*
import javax.inject.Inject

class SaveUserViewModel @Inject constructor(
    private val getSaveUsersUseCase: GetSaveUsersUseCase,
    private val deleteSaveUserUseCase: DeleteSaveUserUseCase
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

    fun getSaveUsers() {
        _state.value = InProgress
        viewModelScope.launch(errorStateHandlerException) {
            val list = getSaveUsersUseCase()
            if (list.isEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
                _dataList.value = list
            }
        }
    }

    fun deleteSaveUsers(id: Long) {
        viewModelScope.launch(errorStateHandlerException) {
            deleteSaveUserUseCase(id)
            _dataList.value = _dataList.value?.filter { it.id != id }
            if (_dataList.value.isNullOrEmpty()) {
                _state.value = EmptyResult
            } else {
                _state.value = Result
            }
        }
    }
}