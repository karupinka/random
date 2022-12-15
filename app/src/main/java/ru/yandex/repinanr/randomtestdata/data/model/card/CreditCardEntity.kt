package ru.yandex.repinanr.randomtestdata.data.model.card

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "credit_cards",
    indices = [
        Index(value = ["id"])
    ]
)
data class CreditCardEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "credit_card_number")
    val number: String,
    @ColumnInfo(name = "credit_card_expiry_date")
    val expiryDate: String,
    @ColumnInfo(name = "credit_card_type")
    val type: String
)
