package ru.yandex.repinanr.randomtestdata

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import ru.yandex.repinanr.randomtestdata.domain.mapper.RandomDataMapper
import ru.yandex.repinanr.randomtestdata.data.model.address.AddressEntity
import ru.yandex.repinanr.randomtestdata.data.model.address.AddressResponse
import ru.yandex.repinanr.randomtestdata.data.model.bank.BankEntity
import ru.yandex.repinanr.randomtestdata.data.model.bank.BankResponse
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardEntity
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardResponse
import ru.yandex.repinanr.randomtestdata.data.model.common.AddressModel
import ru.yandex.repinanr.randomtestdata.data.model.common.BankModel
import ru.yandex.repinanr.randomtestdata.data.model.common.CreditCardModel
import ru.yandex.repinanr.randomtestdata.data.model.common.UserModel
import ru.yandex.repinanr.randomtestdata.data.model.user.ResponseUserModel
import ru.yandex.repinanr.randomtestdata.data.model.user.UserEntity

class RandomDataMapperUnitTest {
    private lateinit var randomDataMapper: RandomDataMapper

    @Before
    fun setUp() {
        randomDataMapper = RandomDataMapper()
    }

    @Test
    fun checkMapUserResponseToUserModel() {
        val mapResponse = randomDataMapper.mapUserResponseToUserModel(getUserResponse())
        assertEquals(mapResponse::class.java, UserModel::class.java)
        assertEquals(mapResponse, getUserModel())
    }

    @Test
    fun checkMapUserEntityToUserModel() {
        val mapEntity = randomDataMapper.mapUserEntityToUserModel(getUserEntity())
        assertEquals(mapEntity::class.java, UserModel::class.java)
        assertEquals(mapEntity, getUserModel())
    }

    @Test
    fun checkUserModelMapToUserEntity() {
        val mapEntity = randomDataMapper.mapUserModelToUserEntity(getUserModel())
        assertEquals(mapEntity::class.java, UserEntity::class.java)
        assertEquals(mapEntity, getUserEntity())
    }

    @Test
    fun checkMapListUserEntityToListUserModel() {
        val listEntity = randomDataMapper.mapListUserEntityToListUserModel(
            listOf(getUserEntity())
        )
        val listModel = listOf(getUserModel())
        assertEquals(listEntity.size, listModel.size)
        assertEquals(listEntity, listModel)
    }

    @Test
    fun checkMapBankResponseToBankModel() {
        val mapResponse = randomDataMapper.mapBankResponseToBankModel(getBankResponse())
        assertEquals(mapResponse::class.java, BankModel::class.java)
        assertEquals(mapResponse, getBankModel())
    }

    @Test
    fun checkMapBankEntityToBankModel() {
        val mapResponse = randomDataMapper.mapBankEntityToBankModel(getBankEntity())
        assertEquals(mapResponse::class.java, BankModel::class.java)
        assertEquals(mapResponse, getBankModel())
    }

    @Test
    fun checkBankModelMapToBankEntity() {
        val mapResponse = randomDataMapper.mapBankModelToBankEntity(getBankModel())
        assertEquals(mapResponse::class.java, BankEntity::class.java)
        assertEquals(mapResponse, getBankEntity())
    }

    @Test
    fun checkMapListBankEntityToListBankModel() {
        val listEntity = randomDataMapper.mapListBankEntityToListBankModel(
            listOf(getBankEntity())
        )
        val listModel = listOf(getBankModel())
        assertEquals(listEntity.size, listModel.size)
        assertEquals(listEntity, listModel)
    }

    @Test
    fun checkMapCreditCardResponseToCreditCardModel() {
        val mapResponse = randomDataMapper.mapCreditCardResponseToCreditCardModel(
            getCreditCardResponse()
        )
        assertEquals(mapResponse::class.java, CreditCardModel::class.java)
        assertEquals(mapResponse, getCreditCardModel())
    }

    @Test
    fun checkMapCreditCardEntityToCreditCardModel() {
        val mapResponse = randomDataMapper.mapCreditCardEntityToCreditCardModel(getCreditCardEntity())
        assertEquals(mapResponse::class.java, CreditCardModel::class.java)
        assertEquals(mapResponse, getCreditCardModel())
    }

    @Test
    fun checkCreditCardModelMapToCreditCardEntity() {
        val mapResponse = randomDataMapper.mapCreditCardModelToCreditCardEntity(getCreditCardModel())
        assertEquals(mapResponse::class.java, CreditCardEntity::class.java)
        assertEquals(mapResponse, getCreditCardEntity())
    }

    @Test
    fun checkMapListCreditCardEntityToListCreditCardModel() {
        val listEntity = randomDataMapper.mapListCreditCardEntityToListCreditCardModel(
            listOf(getCreditCardEntity())
        )
        val listModel = listOf(getCreditCardModel())
        assertEquals(listEntity.size, listModel.size)
        assertEquals(listEntity, listModel)
    }

    @Test
    fun checkMapAddressResponseToAddressModel() {
        val mapResponse = randomDataMapper.mapAddressResponseToAddressModel(
            getAddressResponse()
        )
        assertEquals(mapResponse::class.java, AddressModel::class.java)
        assertEquals(mapResponse, getAddressModel())
    }

    @Test
    fun checkMapAddressEntityToAddressModel() {
        val mapResponse = randomDataMapper.mapAddressEntityToAddressModel(getAddressEntity())
        assertEquals(mapResponse::class.java, AddressModel::class.java)
        assertEquals(mapResponse, getAddressModel())
    }

    @Test
    fun checkAddressModelMapToAddressEntity() {
        val mapResponse = randomDataMapper.mapAddressModelToAddressEntity(getAddressModel())
        assertEquals(mapResponse::class.java, AddressEntity::class.java)
        assertEquals(mapResponse, getAddressEntity())
    }

    @Test
    fun checkMapListAddressEntityToListAddressModel() {
        val listEntity = randomDataMapper.mapListAddressEntityToListAddressModel(
            listOf(getAddressEntity())
        )
        val listModel = listOf(getAddressModel())
        assertEquals(listEntity.size, listModel.size)
        assertEquals(listEntity, listModel)
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
            gender = "mail",
            phoneNumber = "+7 977 777 77 77",
            insuranceNumber = "23456",
            birthDate = "23.12.1976"
        )

        fun getUserResponse() = ResponseUserModel(
            id = 1L,
            password = "password",
            firstName = "Test",
            lastName = "Testov",
            username = "username",
            email = "email@mail.ru",
            avatar = "https://test.ru",
            gender = "mail",
            phoneNumber = "+7 977 777 77 77",
            insuranceNumber = "23456",
            birthDate = "23.12.1976"
        )

        fun getUserEntity() = UserEntity(
            id = 1L,
            password = "password",
            firstName = "Test",
            lastName = "Testov",
            username = "username",
            email = "email@mail.ru",
            avatar = "https://test.ru",
            gender = "mail",
            phoneNumber = "+7 977 777 77 77",
            insuranceNumber = "23456",
            birthDate = "23.12.1976"
        )

        fun getBankEntity() = BankEntity(
            id = 1L,
            accountNumber = "4179357008",
            iban = "GB43UNLA29371043608077",
            bankName = "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)",
            routingNumber = "680263762",
            swiftBic = "BOFAGB22SEC"
        )

        fun getBankModel() = BankModel(
            id = 1L,
            accountNumber = "4179357008",
            iban = "GB43UNLA29371043608077",
            bankName = "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)",
            routingNumber = "680263762",
            swiftBic = "BOFAGB22SEC"
        )

        fun getBankResponse() = BankResponse(
            id = 1L,
            accountNumber = "4179357008",
            iban = "GB43UNLA29371043608077",
            bankName = "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)",
            routingNumber = "680263762",
            swiftBic = "BOFAGB22SEC"
        )

        fun getCreditCardResponse() = CreditCardResponse(
            id = 1L,
            number = "1228-1221-1221-1431",
            expiryDate = "2026-12-14",
            type = "mastercard"
        )

        fun getCreditCardModel() = CreditCardModel(
            id = 1L,
            number = "1228-1221-1221-1431",
            expiryDate = "2026-12-14",
            type = "mastercard"
        )

        fun getCreditCardEntity() = CreditCardEntity(
            id = 1L,
            number = "1228-1221-1221-1431",
            expiryDate = "2026-12-14",
            type = "mastercard"
        )

        fun getAddressEntity() = AddressEntity(
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

        fun getAddressResponse() = AddressResponse(
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