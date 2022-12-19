package ru.yandex.repinanr.domain.model

data class CreditCardModel(
    override val id: Long,
    val number: String,
    val expiryDate: String,
    val type: String
) : DataModel()
