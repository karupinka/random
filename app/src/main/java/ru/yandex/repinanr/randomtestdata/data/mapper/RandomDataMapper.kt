package ru.yandex.repinanr.randomtestdata.data.mapper

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
import javax.inject.Inject

class RandomDataMapper @Inject constructor() {

    fun mapUserResponseToUserModel(responseUser: ResponseUserModel) = UserModel(
        id = responseUser.id,
        password = responseUser.password,
        firstName = responseUser.firstName,
        lastName = responseUser.lastName,
        username = responseUser.username,
        email = responseUser.email,
        avatar = responseUser.avatar,
        gender = responseUser.gender,
        phoneNumber = responseUser.phoneNumber,
        insuranceNumber = responseUser.insuranceNumber,
        birthDate = responseUser.birthDate
    )

    fun mapUserModelToUserEntity(user: UserModel) = UserEntity(
        id = user.id,
        password = user.password,
        firstName = user.firstName,
        lastName = user.lastName,
        username = user.username,
        email = user.email,
        avatar = user.avatar,
        gender = user.gender,
        phoneNumber = user.phoneNumber,
        insuranceNumber = user.insuranceNumber,
        birthDate = user.birthDate
    )

    fun mapUserEntityToUserModel(userEntity: UserEntity) = UserModel(
        id = userEntity.id,
        password = userEntity.password,
        firstName = userEntity.firstName,
        lastName = userEntity.lastName,
        username = userEntity.username,
        email = userEntity.email,
        avatar = userEntity.avatar,
        gender = userEntity.gender,
        phoneNumber = userEntity.phoneNumber,
        insuranceNumber = userEntity.insuranceNumber,
        birthDate = userEntity.birthDate
    )

    fun mapListUserEntityToListUserModel(listUserEntity: List<UserEntity>) = listUserEntity.map {
        mapUserEntityToUserModel(it)
    }

    fun mapCreditCardResponseToCreditCardModel(cardResponse: CreditCardResponse) = CreditCardModel(
        id = cardResponse.id,
        number = cardResponse.number,
        expiryDate = cardResponse.expiryDate,
        type = cardResponse.type
    )

    fun mapCreditCardEntityToCreditCardModel(cardEntity: CreditCardEntity) = CreditCardModel(
        id = cardEntity.id,
        number = cardEntity.number,
        expiryDate = cardEntity.expiryDate,
        type = cardEntity.type
    )

    fun mapCreditCardModelToCreditCardEntity(cardModel: CreditCardModel) = CreditCardEntity(
        id = cardModel.id,
        number = cardModel.number,
        expiryDate = cardModel.expiryDate,
        type = cardModel.type
    )

    fun mapListCreditCardEntityToListCreditCardModel(listCreditCardEntity: List<CreditCardEntity>) =
        listCreditCardEntity.map {
            mapCreditCardEntityToCreditCardModel(it)
        }

    fun mapBankResponseToBankModel(bankResponse: BankResponse) = BankModel(
        id = bankResponse.id,
        accountNumber = bankResponse.accountNumber,
        iban = bankResponse.iban,
        bankName = bankResponse.bankName,
        routingNumber = bankResponse.routingNumber,
        swiftBic = bankResponse.swiftBic
    )

    fun mapBankEntityToBankModel(bankEntity: BankEntity) = BankModel(
        id = bankEntity.id,
        accountNumber = bankEntity.accountNumber,
        iban = bankEntity.iban,
        bankName = bankEntity.bankName,
        routingNumber = bankEntity.routingNumber,
        swiftBic = bankEntity.swiftBic
    )

    fun mapBankModelToBankEntity(bankModel: BankModel) = BankEntity(
        id = bankModel.id,
        accountNumber = bankModel.accountNumber,
        iban = bankModel.iban,
        bankName = bankModel.bankName,
        routingNumber = bankModel.routingNumber,
        swiftBic = bankModel.swiftBic
    )

    fun mapListBankEntityToListBankModel(listBankEntity: List<BankEntity>) =
        listBankEntity.map {
            mapBankEntityToBankModel(it)
        }


    fun mapAddressEntityToAddressModel(addressEntity: AddressEntity) = AddressModel(
        id = addressEntity.id,
        city = addressEntity.city,
        streetName = addressEntity.streetName,
        streetAddress = addressEntity.streetAddress,
        secondaryAddress = addressEntity.secondaryAddress,
        buildingNumber = addressEntity.buildingNumber,
        mailBox = addressEntity.mailBox,
        community = addressEntity.community,
        zipCode = addressEntity.zipCode,
        zip = addressEntity.zip,
        postcode = addressEntity.postcode,
        timeZone = addressEntity.timeZone,
        streetSuffix = addressEntity.streetSuffix,
        citySuffix = addressEntity.citySuffix,
        cityPrefix = addressEntity.cityPrefix,
        state = addressEntity.state,
        stateAbbr = addressEntity.stateAbbr,
        country = addressEntity.country,
        countryCode = addressEntity.countryCode,
        latitude = addressEntity.latitude,
        longitude = addressEntity.longitude,
        fullAddress = addressEntity.fullAddress
    )

    fun mapAddressResponseToAddressModel(addressResponse: AddressResponse) = AddressModel(
        id = addressResponse.id,
        city = addressResponse.city,
        streetName = addressResponse.streetName,
        streetAddress = addressResponse.streetAddress,
        secondaryAddress = addressResponse.secondaryAddress,
        buildingNumber = addressResponse.buildingNumber,
        mailBox = addressResponse.mailBox,
        community = addressResponse.community,
        zipCode = addressResponse.zipCode,
        zip = addressResponse.zip,
        postcode = addressResponse.postcode,
        timeZone = addressResponse.timeZone,
        streetSuffix = addressResponse.streetSuffix,
        citySuffix = addressResponse.citySuffix,
        cityPrefix = addressResponse.cityPrefix,
        state = addressResponse.state,
        stateAbbr = addressResponse.stateAbbr,
        country = addressResponse.country,
        countryCode = addressResponse.countryCode,
        latitude = addressResponse.latitude,
        longitude = addressResponse.longitude,
        fullAddress = addressResponse.fullAddress
    )

    fun mapAddressModelToAddressEntity(addressModel: AddressModel) = AddressEntity(
        id = addressModel.id,
        city = addressModel.city,
        streetName = addressModel.streetName,
        streetAddress = addressModel.streetAddress,
        secondaryAddress = addressModel.secondaryAddress,
        buildingNumber = addressModel.buildingNumber,
        mailBox = addressModel.mailBox,
        community = addressModel.community,
        zipCode = addressModel.zipCode,
        zip = addressModel.zip,
        postcode = addressModel.postcode,
        timeZone = addressModel.timeZone,
        streetSuffix = addressModel.streetSuffix,
        citySuffix = addressModel.citySuffix,
        cityPrefix = addressModel.cityPrefix,
        state = addressModel.state,
        stateAbbr = addressModel.stateAbbr,
        country = addressModel.country,
        countryCode = addressModel.countryCode,
        latitude = addressModel.latitude,
        longitude = addressModel.longitude,
        fullAddress = addressModel.fullAddress
    )

    fun mapListAddressEntityToListAddressModel(listAddressEntity: List<AddressEntity>) =
        listAddressEntity.map {
            mapAddressEntityToAddressModel(it)
        }
}