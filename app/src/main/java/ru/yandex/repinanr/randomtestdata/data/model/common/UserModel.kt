package ru.yandex.repinanr.randomtestdata.data.model.common

data class UserModel(
    override val id: Long,
    val password: String,
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val avatar: String,
    val gender: String,
    val phoneNumber: String,
    val insuranceNumber: String,
    val birthDate: String
) : DataModel()
