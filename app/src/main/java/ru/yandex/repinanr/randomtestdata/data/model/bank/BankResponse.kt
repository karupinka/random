package ru.yandex.repinanr.randomtestdata.data.model.bank

import com.google.gson.annotations.SerializedName

data class BankResponse(
    val id: Int,
    @SerializedName("account_number")
    val accountNumber: String,
    val iban: String,
    @SerializedName("bank_name")
    val bankName: String,
    @SerializedName("routing_number")
    val routingNumber: String,
    @SerializedName("swift_bic")
    val swiftBic: String
)
