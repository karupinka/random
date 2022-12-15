package ru.yandex.repinanr.randomtestdata.domain

import ru.yandex.repinanr.randomtestdata.data.model.common.AddressModel
import ru.yandex.repinanr.randomtestdata.data.model.common.BankModel
import ru.yandex.repinanr.randomtestdata.data.model.common.CreditCardModel
import ru.yandex.repinanr.randomtestdata.data.model.common.UserModel

interface RandomDataRepository {

    // User
    suspend fun getUser(): UserModel

    suspend fun getSaveUsers(): List<UserModel>

    suspend fun getSaveUser(id: Long): UserModel?

    suspend fun saveUser(user: UserModel)

    suspend fun deleteSaveUser(id: Long)

    // Bank
    suspend fun getBank(): BankModel

    suspend fun getSaveBanks(): List<BankModel>

    suspend fun getSaveBank(id: Long): BankModel?

    suspend fun saveBank(bank: BankModel)

    suspend fun deleteSaveBank(id: Long)

    // CreditCard
    suspend fun getCreditCard(): CreditCardModel

    suspend fun getSaveCreditCards(): List<CreditCardModel>

    suspend fun getSaveCreditCard(id: Long): CreditCardModel?

    suspend fun saveCreditCard(creditCard: CreditCardModel)

    suspend fun deleteSaveCreditCard(id: Long)

    // Address
    suspend fun getAddress(): AddressModel

    suspend fun getSaveAddresses(): List<AddressModel>

    suspend fun getSaveAddress(id: Long): AddressModel?

    suspend fun saveAddress(address: AddressModel)

    suspend fun deleteSaveAddress(id: Long)
}