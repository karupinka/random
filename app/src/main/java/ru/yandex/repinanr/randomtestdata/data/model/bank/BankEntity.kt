package ru.yandex.repinanr.randomtestdata.data.model.bank

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "banks",
    indices = [
        Index(value = ["id"])
    ]
)
data class BankEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "account_number")
    val accountNumber: String,
    val iban: String,
    @ColumnInfo(name = "bank_name")
    val bankName: String,
    @ColumnInfo(name = "routing_number")
    val routingNumber: String,
    @ColumnInfo(name = "swift_bic")
    val swiftBic: String
)
