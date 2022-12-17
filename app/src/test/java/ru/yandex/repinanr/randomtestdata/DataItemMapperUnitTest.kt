package ru.yandex.repinanr.randomtestdata

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import ru.yandex.repinanr.randomtestdata.data.mapper.DataItemMapper
import ru.yandex.repinanr.randomtestdata.data.model.common.AddressModel
import ru.yandex.repinanr.randomtestdata.data.model.common.BankModel
import ru.yandex.repinanr.randomtestdata.data.model.common.CreditCardModel
import ru.yandex.repinanr.randomtestdata.data.model.common.UserModel
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataItemModel

class DataItemMapperUnitTest {
    private lateinit var dataItemMapper: DataItemMapper

    @Before
    fun setUp() {
        dataItemMapper = DataItemMapper()
    }

    @Test
    fun checkMapUserResponseToUserModel() {
        val mapResponse = dataItemMapper.mapUserToListDataItem(getUserModel())
        val dataItem = listOf(
            DataItemModel(R.string.user_password, "password"),
            DataItemModel(R.string.user_first_name, "Test"),
            DataItemModel(R.string.user_last_name, "Testov"),
            DataItemModel(R.string.user_username, "username"),
            DataItemModel(R.string.user_email, "email@mail.ru"),
            DataItemModel(R.string.user_avatar, "https://test.ru"),
            DataItemModel(R.string.user_gender, "male"),
            DataItemModel(R.string.user_phone_number, "+7 977 777 77 77"),
            DataItemModel(R.string.user_social_insurance_number, "23456"),
            DataItemModel(R.string.user_date_of_birth, "23.12.1976")
        )
        assertEquals(mapResponse, dataItem)
    }

    @Test
    fun checkMapBankResponseToBankModel() {
        val mapResponse = dataItemMapper.mapBankModelToListDataItem(getBankModel())
        val dataItem = listOf(
            DataItemModel(
                R.string.bank_name_title,
                "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)"
            ),
            DataItemModel(R.string.account_number_title, "4179357008"),
            DataItemModel(R.string.iban_title, "GB43UNLA29371043608077"),
            DataItemModel(R.string.routing_number_title, "680263762"),
            DataItemModel(R.string.swift_bic_title, "BOFAGB22SEC")
        )
        assertEquals(mapResponse, dataItem)
    }

    @Test
    fun checkMapCreditCardResponseToCreditCardModel() {
        val mapResponse = dataItemMapper.mapCreditCardToListDataItem(getCreditCardModel())
        val dataItem = listOf(
            DataItemModel(R.string.credit_card_number, "1228-1221-1221-1431"),
            DataItemModel(R.string.credit_card_expiry_date, "2026-12-14"),
            DataItemModel(R.string.credit_card_type, "mastercard")
        )
        assertEquals(mapResponse, dataItem)
    }

    @Test
    fun checkMapAddressResponseToAddressModel() {
        val mapResponse = dataItemMapper.mapAddressToListDataItem(getAddressModel())
        val dataItem = listOf(
            DataItemModel(R.string.address_city, "Port Margarito"),
            DataItemModel(R.string.address_street_name, "Markus Route"),
            DataItemModel(R.string.address_street_address, "293 Bergstrom Road"),
            DataItemModel(R.string.address_secondary_address, "Apt. 75"),
            DataItemModel(R.string.address_building_number, "18789"),
            DataItemModel(R.string.address_mail_box, "PO Box 4128"),
            DataItemModel(R.string.address_community, "Autumn Place"),
            DataItemModel(R.string.address_zip_сode, "11417-3129"),
            DataItemModel(R.string.address_zip, "06729"),
            DataItemModel(R.string.address_postcode, "6319-8341"),
            DataItemModel(R.string.address_time_zone, "Europe/Sofia"),
            DataItemModel(R.string.address_street_suffix, "Light"),
            DataItemModel(R.string.address_city_suffix, "fort"),
            DataItemModel(R.string.address_city_prefix, "North"),
            DataItemModel(R.string.address_state, "Washington"),
            DataItemModel(R.string.address_state_abbr, "WA"),
            DataItemModel(R.string.address_country, "Czech Republic"),
            DataItemModel(R.string.address_country_code, "ER"),
            DataItemModel(R.string.address_latitude, "-73.43818193805095"),
            DataItemModel(R.string.address_longitude, "131.19336546266555"),
            DataItemModel(
                R.string.address_full_address,
                "Apt. 849 9196 Batz Brooks, Laurihaven, UT 98084"
            )
        )
        assertEquals(mapResponse, dataItem)
    }

    @Test
    fun checkMapDataModelToListDataItemAddress() {
        val mapResponse = dataItemMapper.mapDataModelToListDataItem(getAddressModel())
        assertEquals(
            mapResponse[0],
            DataItemModel(R.string.address_city, "Port Margarito")
        )
    }

    @Test
    fun checkMapDataModelToListDataItemBank() {
        val mapResponse = dataItemMapper.mapDataModelToListDataItem(getBankModel())
        assertEquals(
            mapResponse[0],
            DataItemModel(
                R.string.bank_name_title,
                "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)"
            )
        )
    }

    @Test
    fun checkMapDataModelToListDataItemCreditCard() {
        val mapResponse = dataItemMapper.mapDataModelToListDataItem(getCreditCardModel())
        assertEquals(
            mapResponse[0],
            DataItemModel(R.string.credit_card_number, "1228-1221-1221-1431")
        )
    }

    @Test
    fun checkMapDataModelToListDataItemUser() {
        val mapResponse = dataItemMapper.mapDataModelToListDataItem(getUserModel())
        assertEquals(
            mapResponse[0],
            DataItemModel(R.string.user_password, "password")
        )
    }

    companion object {
        fun getUserModel() = UserModel(
            id = 1L,
            password = "password",
            firstName = "Test",
            lastName = "Testov",
            username = "username",
            email = "email@mail.ru",
            avatar = "https://test.ru",
            gender = "male",
            phoneNumber = "+7 977 777 77 77",
            insuranceNumber = "23456",
            birthDate = "23.12.1976"
        )

        fun getBankModel() = BankModel(
            id = 1L,
            accountNumber = "4179357008",
            iban = "GB43UNLA29371043608077",
            bankName = "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)",
            routingNumber = "680263762",
            swiftBic = "BOFAGB22SEC"
        )

        fun getCreditCardModel() = CreditCardModel(
            id = 1L,
            number = "1228-1221-1221-1431",
            expiryDate = "2026-12-14",
            type = "mastercard"
        )

        fun getAddressModel() = AddressModel(
            id = 1L,
            city = "Port Margarito",
            streetName = "Markus Route",
            streetAddress = "293 Bergstrom Road",
            secondaryAddress = "Apt. 75",
            buildingNumber = "18789",
            mailBox = "PO Box 4128",
            community = "Autumn Place",
            zipCode = "11417-3129",
            zip = "06729",
            postcode = "6319-8341",
            timeZone = "Europe/Sofia",
            streetSuffix = "Light",
            citySuffix = "fort",
            cityPrefix = "North",
            state = "Washington",
            stateAbbr = "WA",
            country = "Czech Republic",
            countryCode = "ER",
            latitude = -73.43818193805095,
            longitude = 131.19336546266555,
            fullAddress = "Apt. 849 9196 Batz Brooks, Laurihaven, UT 98084"
        )
    }
}