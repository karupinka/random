package ru.yandex.repinanr.randomtestdata.data.model.card

import com.google.gson.annotations.SerializedName

data class CreditCardResponse(
    val id: Long,
    @SerializedName("credit_card_number")
    val number: String,
    @SerializedName("credit_card_expiry_date")
    val expiryDate: String,
    @SerializedName("credit_card_type")
    val type: String
)
