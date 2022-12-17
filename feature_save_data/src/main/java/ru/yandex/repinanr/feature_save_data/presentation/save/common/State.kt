package ru.yandex.repinanr.randomtestdata.presentation.save.common

sealed class State

object Error : State()
object InProgress : State()
object EmptyResult : State()
object Result : State()