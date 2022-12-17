package ru.yandex.repinanr.randomtestdata.domain.model

data class BankModel(
    override val id: Long,
    val accountNumber: String,
    val iban: String,
    val bankName: String,
    val routingNumber: String,
    val swiftBic: String
) : DataModel()
