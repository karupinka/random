package ru.yandex.repinanr.randomtestdata.data.model.user

import com.google.gson.annotations.SerializedName

data class ResponseUserModel(
    val id: Long,
    val password: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("social_insurance_number")
    val insuranceNumber: String,
    @SerializedName("date_of_birth")
    val birthDate: String
)
