package ru.yandex.repinanr.detail.presentation

import androidx.annotation.StringRes
import ru.yandex.repinanr.detail.R

enum class Datas(@StringRes val title: Int) {
    USER(R.string.user_title),
    CREDIT_CARD(R.string.credit_card_title),
    BANK(R.string.bank_title),
    ADDRESS(R.string.address_title)
}