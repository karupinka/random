package ru.yandex.repinanr.detail.presentation

sealed class State

object Error : State()
class HttpError(code: Int) : State()
object InternetError : State()
object InProgress : State()
class ResultList(
    val list: List<DataItemModel>
) : State()