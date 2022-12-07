package ru.yandex.repinanr.randomtestdata.domain

import androidx.lifecycle.LiveData
import ru.yandex.repinanr.randomtestdata.data.model.address.AddressModel
import ru.yandex.repinanr.randomtestdata.data.model.bank.BankModel
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardModel
import ru.yandex.repinanr.randomtestdata.data.model.user.UserModel

interface RandomDataRepository {

    // User
    suspend fun getUser(): UserModel

    suspend fun getSaveUsers(): LiveData<List<UserModel>>

    suspend fun getSaveUser(id: String): UserModel?

    suspend fun saveUser(user: UserModel)

    suspend fun deleteSaveUser(user: UserModel)

    suspend fun deleteSaveUser(id: String)

    // Bank
    suspend fun getBank(): BankModel

    suspend fun getSaveBanks(): LiveData<List<BankModel>>

    suspend fun getSaveBank(id: String): BankModel?

    suspend fun saveBank(bank: BankModel)

    suspend fun deleteSaveBank(bank: BankModel)

    suspend fun deleteSaveBank(id: String)

    // CreditCard
    suspend fun getCreditCard(): CreditCardModel

    suspend fun getSaveCreditCards(): LiveData<List<CreditCardModel>>

    suspend fun getSaveCreditCard(id: String): CreditCardModel?

    suspend fun saveCreditCard(creditCard: CreditCardModel)

    suspend fun deleteSaveCreditCard(creditCard: CreditCardModel)

    suspend fun deleteSaveCreditCard(id: String)

    // Address
    suspend fun getAddress(): AddressModel

    suspend fun getSaveAddresses(): LiveData<List<AddressModel>>

    suspend fun getSaveAddress(id: String): AddressModel?

    suspend fun saveAddress(address: AddressModel)

    suspend fun deleteSaveAddress(address: AddressModel)

    suspend fun deleteSaveAddress(id: String)
}