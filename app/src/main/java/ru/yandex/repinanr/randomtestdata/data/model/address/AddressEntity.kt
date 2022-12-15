package ru.yandex.repinanr.randomtestdata.data.model.address

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "addresses",
    indices = [
        Index(value = ["id"])
    ]
)
data class AddressEntity(
    @PrimaryKey
    val id: Long,
    val city: String,
    @ColumnInfo(name = "street_name")
    val streetName: String,
    @ColumnInfo(name = "street_address")
    val streetAddress: String,
    @ColumnInfo(name = "secondary_address")
    val secondaryAddress: String,
    @ColumnInfo(name = "building_number")
    val buildingNumber: String,
    @ColumnInfo(name = "mail_box")
    val mailBox: String,
    val community: String,
    @ColumnInfo(name = "zip_code")
    val zipCode: String,
    val zip: String,
    val postcode: String,
    @ColumnInfo(name = "time_zone")
    val timeZone: String,
    @ColumnInfo(name = "street_suffix")
    val streetSuffix: String,
    @ColumnInfo(name = "city_suffix")
    val citySuffix: String,
    @ColumnInfo(name = "city_prefix")
    val cityPrefix: String,
    val state: String,
    @ColumnInfo(name = "state_abbr")
    val stateAbbr: String,
    val country: String,
    @ColumnInfo(name = "country_code")
    val countryCode: String,
    val latitude: Double,
    val longitude: Double,
    @ColumnInfo(name = "full_address")
    val fullAddress: String
)
