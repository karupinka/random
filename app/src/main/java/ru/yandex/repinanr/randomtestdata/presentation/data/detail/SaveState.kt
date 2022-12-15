package ru.yandex.repinanr.randomtestdata.presentation.data.detail

sealed class SaveState

object SaveError : SaveState()
object SaveProgress : SaveState()
object SaveResult : SaveState()