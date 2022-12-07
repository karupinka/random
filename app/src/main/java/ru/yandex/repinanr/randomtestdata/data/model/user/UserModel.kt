package ru.yandex.repinanr.randomtestdata.data.model.user

import androidx.room.ColumnInfo

data class UserModel(
    val id: Int,
    val password: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val username: String,
    val email: String,
    val avatar: String,
    val gender: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "social_insurance_number")
    val insuranceNumber: String,
    @ColumnInfo(name = "date_of_birth")
    val birthDate: String
)
