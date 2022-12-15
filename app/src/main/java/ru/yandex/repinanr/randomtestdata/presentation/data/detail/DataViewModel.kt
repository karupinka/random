package ru.yandex.repinanr.randomtestdata.presentation.data.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.yandex.repinanr.randomtestdata.data.mapper.DataItemMapper
import ru.yandex.repinanr.randomtestdata.data.model.common.DataModel
import ru.yandex.repinanr.randomtestdata.domain.DataTypes
import ru.yandex.repinanr.randomtestdata.domain.usecases.GetDataUseCase
import ru.yandex.repinanr.randomtestdata.domain.usecases.GetSaveDataUseCase
import ru.yandex.repinanr.randomtestdata.domain.usecases.SaveDataUseCase
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class DataViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
    private val getSaveDataUseCase: GetSaveDataUseCase,
    private val saveDataUseCase: SaveDataUseCase,
    private val dataItemMapper: DataItemMapper
) : ViewModel() {
    private lateinit var dataModel: DataModel
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    private val _saveState = MutableLiveData<SaveState>()
    val saveState: LiveData<SaveState>
        get() = _saveState

    private val errorStateHandlerException = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is UnknownHostException -> {
                _state.value = InternetError
            }
            is SocketTimeoutException -> {
                _state.value = InternetError
            }
            is ConnectException -> {
                _state.value = InternetError
            }
            is HttpException -> {
                _state.value = HttpError(throwable.code())
            }
            else -> {
                _state.value = Error
            }
        }
    }

    private val errorSaveHandlerException = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is Exception -> {
                _saveState.value = SaveError
            }
        }
    }

    fun getData(id: Long, type: Datas) {
        _state.value = InProgress
        viewModelScope.launch(errorStateHandlerException) {
            if (id == DEFAULT_ARG) {
                dataModel = getDataUseCase(getType(type))
                _state.value = ResultList(dataItemMapper.mapDataModelToListDataItem(dataModel))
            } else {
                val value = getSaveDataUseCase(id, getType(type))
                if (value != null) {
                    _state.value = ResultList(dataItemMapper.mapDataModelToListDataItem(value))
                } else {
                    _state.value = Error
                }
            }
        }
    }

    private fun getType(type: Datas) = when (type) {
        Datas.USER -> DataTypes.USER
        Datas.CREDIT_CARD -> DataTypes.CREDIT_CARD
        Datas.BANK -> DataTypes.BANK
        Datas.ADDRESS -> DataTypes.ADDRESS
    }

    fun saveData(id: Long) {
        _state.value = InProgress
        viewModelScope.launch(errorSaveHandlerException) {
            saveDataUseCase(dataModel)
            _saveState.value = SaveResult
        }
    }

    companion object {
        const val DEFAULT_ARG = 0L
    }
}