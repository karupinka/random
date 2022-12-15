package ru.yandex.repinanr.randomtestdata.data.model.common

data class BankModel(
    override val id: Long,
    val accountNumber: String,
    val iban: String,
    val bankName: String,
    val routingNumber: String,
    val swiftBic: String
) : DataModel()
