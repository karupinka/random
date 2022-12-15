package ru.yandex.repinanr.randomtestdata.data.model.common

data class CreditCardModel(
    override val id: Long,
    val number: String,
    val expiryDate: String,
    val type: String
) : DataModel()
