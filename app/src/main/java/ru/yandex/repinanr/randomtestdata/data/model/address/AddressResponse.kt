package ru.yandex.repinanr.randomtestdata.data.model.address

import com.google.gson.annotations.SerializedName

data class AddressResponse(
    val id: Int,
    @SerializedName("city")
    val city: String,
    @SerializedName("street_name")
    val streetName: String,
    @SerializedName("street_address")
    val streetAddress: String,
    @SerializedName("secondary_address")
    val secondaryAddress: String,
    @SerializedName("building_number")
    val buildingNumber: String,
    @SerializedName("mail_box")
    val mailBox: String,
    @SerializedName("community")
    val community: String,
    @SerializedName("zip_code")
    val zipCode: String,
    @SerializedName("zip")
    val zip: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("time_zone")
    val timeZone: String,
    @SerializedName("street_suffix")
    val streetSuffix: String,
    @SerializedName("city_suffix")
    val citySuffix: String,
    @SerializedName("city_prefix")
    val cityPrefix: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("state_abbr")
    val stateAbbr: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("full_address")
    val fullAddress: String
)
