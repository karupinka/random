package ru.yandex.repinanr.randomtestdata.data.model.common

data class AddressModel(
    override val id: Long,
    val city: String,
    val streetName: String,
    val streetAddress: String,
    val secondaryAddress: String,
    val buildingNumber: String,
    val mailBox: String,
    val community: String,
    val zipCode: String,
    val zip: String,
    val postcode: String,
    val timeZone: String,
    val streetSuffix: String,
    val citySuffix: String,
    val cityPrefix: String,
    val state: String,
    val stateAbbr: String,
    val country: String,
    val countryCode: String,
    val latitude: Double,
    val longitude: Double,
    val fullAddress: String
) : DataModel()
