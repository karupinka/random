package ru.yandex.repinanr.detail.presentation.mapper

import ru.yandex.repinanr.detail.R
import ru.yandex.repinanr.domain.model.*
import ru.yandex.repinanr.detail.presentation.DataItemModel
import javax.inject.Inject

class DataItemMapper @Inject constructor() {

    fun mapDataModelToListDataItem(dataModel: DataModel): List<DataItemModel> {
        return when(dataModel) {
            is BankModel -> mapBankModelToListDataItem(dataModel)
            is UserModel -> mapUserToListDataItem(dataModel)
            is AddressModel -> mapAddressToListDataItem(dataModel)
            is CreditCardModel -> mapCreditCardToListDataItem(dataModel)
            else -> throw java.lang.ClassCastException("Wrong data class")
        }
    }

    fun mapBankModelToListDataItem(bankModel: BankModel) = listOf(
        DataItemModel(
            R.string.bank_name_title,
            bankModel.bankName
        ),
        DataItemModel(
            R.string.account_number_title,
            bankModel.accountNumber
        ),
        DataItemModel(
            R.string.iban_title,
            bankModel.iban
        ),
        DataItemModel(
            R.string.routing_number_title,
            bankModel.routingNumber
        ),
        DataItemModel(
            R.string.swift_bic_title,
            bankModel.swiftBic
        )
    )

    fun mapCreditCardToListDataItem(creditCardModel: CreditCardModel) = listOf(
        DataItemModel(
            R.string.credit_card_number,
            creditCardModel.number
        ),
        DataItemModel(
            R.string.credit_card_expiry_date,
            creditCardModel.expiryDate
        ),
        DataItemModel(
            R.string.credit_card_type,
            creditCardModel.type
        )
    )

    fun mapAddressToListDataItem(addressModel: AddressModel) = listOf(
        DataItemModel(
            R.string.address_city,
            addressModel.city
        ),
        DataItemModel(
            R.string.address_street_name,
            addressModel.streetName
        ),
        DataItemModel(
            R.string.address_street_address,
            addressModel.streetAddress
        ),
        DataItemModel(
            R.string.address_secondary_address,
            addressModel.secondaryAddress
        ),
        DataItemModel(
            R.string.address_building_number,
            addressModel.buildingNumber
        ),
        DataItemModel(
            R.string.address_mail_box,
            addressModel.mailBox
        ),
        DataItemModel(
            R.string.address_community,
            addressModel.community
        ),
        DataItemModel(
            R.string.address_zip_сode,
            addressModel.zipCode
        ),
        DataItemModel(
            R.string.address_zip,
            addressModel.zip
        ),
        DataItemModel(
            R.string.address_postcode,
            addressModel.postcode
        ),
        DataItemModel(
            R.string.address_time_zone,
            addressModel.timeZone
        ),
        DataItemModel(
            R.string.address_street_suffix,
            addressModel.streetSuffix
        ),
        DataItemModel(
            R.string.address_city_suffix,
            addressModel.citySuffix
        ),
        DataItemModel(
            R.string.address_city_prefix,
            addressModel.cityPrefix
        ),
        DataItemModel(
            R.string.address_state,
            addressModel.state
        ),
        DataItemModel(
            R.string.address_state_abbr,
            addressModel.stateAbbr
        ),
        DataItemModel(
            R.string.address_country,
            addressModel.country
        ),
        DataItemModel(
            R.string.address_country_code,
            addressModel.countryCode
        ),
        DataItemModel(
            R.string.address_latitude,
            addressModel.latitude.toString()
        ),
        DataItemModel(
            R.string.address_longitude,
            addressModel.longitude.toString()
        ),
        DataItemModel(
            R.string.address_full_address,
            addressModel.fullAddress
        )
    )

    fun mapUserToListDataItem(userModel: UserModel) = listOf(
        DataItemModel(
            R.string.user_password,
            userModel.password
        ),
        DataItemModel(
            R.string.user_first_name,
            userModel.firstName
        ),
        DataItemModel(
            R.string.user_last_name,
            userModel.lastName
        ),
        DataItemModel(
            R.string.user_username,
            userModel.username
        ),
        DataItemModel(
            R.string.user_email,
            userModel.email
        ),
        DataItemModel(
            R.string.user_avatar,
            userModel.avatar
        ),
        DataItemModel(
            R.string.user_gender,
            userModel.gender
        ),
        DataItemModel(
            R.string.user_phone_number,
            userModel.phoneNumber
        ),
        DataItemModel(
            R.string.user_social_insurance_number,
            userModel.insuranceNumber
        ),
        DataItemModel(
            R.string.user_date_of_birth,
            userModel.birthDate
        )
    )
}