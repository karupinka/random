package ru.yandex.repinanr.detail.presentation

sealed class SaveState

object SaveError : SaveState()
object SaveProgress : SaveState()
object SaveResult : SaveState()