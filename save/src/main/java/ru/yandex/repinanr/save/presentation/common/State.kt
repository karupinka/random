package ru.yandex.repinanr.save.presentation.common

sealed class State

object Error : State()
object InProgress : State()
object EmptyResult : State()
object Result : State()