package ru.yandex.repinanr.randomtestdata.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.yandex.repinanr.randomtestdata.data.mapper.RandomDataMapper
import ru.yandex.repinanr.randomtestdata.data.model.address.AddressModel
import ru.yandex.repinanr.randomtestdata.data.model.bank.BankModel
import ru.yandex.repinanr.randomtestdata.data.model.card.CreditCardModel
import ru.yandex.repinanr.randomtestdata.data.model.user.UserModel
import ru.yandex.repinanr.randomtestdata.data.remote.RandomDataService
import ru.yandex.repinanr.randomtestdata.data.room.address.AddressDao
import ru.yandex.repinanr.randomtestdata.data.room.bank.BankDao
import ru.yandex.repinanr.randomtestdata.data.room.card.CardDao
import ru.yandex.repinanr.randomtestdata.data.room.user.UserDao
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class RandomDataRepositoryImpl @Inject constructor(
    private val mapper: RandomDataMapper,
    private val service: RandomDataService,
    private val userDao: UserDao,
    private val creditCardDao: CardDao,
    private val bankDao: BankDao,
    private val addressDao: AddressDao
) : RandomDataRepository {
    override suspend fun getUser() = mapper.mapUserResponseToUserModel(service.getUser())

    override suspend fun getSaveUsers() =
        Transformations.map(userDao.getAllUsers()) {
            mapper.mapListUserEntityToListUserModel(it)
        }

    override suspend fun getSaveUser(id: String): UserModel? {
        userDao.getUser(id)?.let {
            return mapper.mapUserEntityToUserModel(it)
        }
        return null
    }

    override suspend fun saveUser(user: UserModel) {
        userDao.insertUser(mapper.mapUserModelToUserEntity(user))
    }

    override suspend fun deleteSaveUser(user: UserModel) {
        userDao.deleteUser(mapper.mapUserModelToUserEntity(user))
    }

    override suspend fun deleteSaveUser(id: String) {
        userDao.deleteUser(id)
    }

    override suspend fun getBank() = mapper.mapBankResponseToBankModel(service.getBank())

    override suspend fun getSaveBanks(): LiveData<List<BankModel>> =
        Transformations.map(bankDao.getAllBanks()) {
            mapper.mapListBankEntityToListBankModel(it)
        }

    override suspend fun getSaveBank(id: String): BankModel? {
        bankDao.getBank(id)?.let {
            return mapper.mapBankEntityToBankModel(it)
        }
        return null
    }

    override suspend fun saveBank(bank: BankModel) {
        bankDao.insertBank(mapper.mapBankModelToBankEntity(bank))
    }

    override suspend fun deleteSaveBank(bank: BankModel) {
        bankDao.deleteBank(mapper.mapBankModelToBankEntity(bank))
    }

    override suspend fun deleteSaveBank(id: String) {
        bankDao.deleteBank(id)
    }

    override suspend fun getCreditCard() =
        mapper.mapCreditCardResponseToCreditCardModel(service.getCreditCard())

    override suspend fun getSaveCreditCards(): LiveData<List<CreditCardModel>> =
        Transformations.map(creditCardDao.getAllCard()) {
            mapper.mapListCreditCardEntityToListCreditCardModel(it)
        }

    override suspend fun getSaveCreditCard(id: String): CreditCardModel? {
        creditCardDao.getCard(id)?.let {
            return mapper.mapCreditCardEntityToCreditCardModel(it)
        }
        return null
    }

    override suspend fun saveCreditCard(creditCard: CreditCardModel) {
        creditCardDao.insertCard(mapper.mapCreditCardModelToCreditCardEntity(creditCard))
    }

    override suspend fun deleteSaveCreditCard(creditCard: CreditCardModel) {
        creditCardDao.deleteCard(mapper.mapCreditCardModelToCreditCardEntity(creditCard))
    }

    override suspend fun deleteSaveCreditCard(id: String) {
        creditCardDao.deleteCard(id)
    }

    override suspend fun getAddress() =
        mapper.mapAddressResponseToAddressModel(service.getAddresses())

    override suspend fun getSaveAddresses(): LiveData<List<AddressModel>> =
        Transformations.map(addressDao.getAllAddresses()) {
            mapper.mapListAddressEntityToListAddressModel(it)
        }

    override suspend fun getSaveAddress(id: String): AddressModel? {
        addressDao.getAddress(id)?.let {
            return mapper.mapAddressEntityToAddressModel(it)
        }
        return null
    }

    override suspend fun saveAddress(address: AddressModel) {
        addressDao.insertAddress(mapper.mapAddressModelToAddressEntity(address))
    }

    override suspend fun deleteSaveAddress(address: AddressModel) {
        addressDao.deleteAddress(mapper.mapAddressModelToAddressEntity(address))
    }

    override suspend fun deleteSaveAddress(id: String) {
        addressDao.deleteAddress(id)
    }
}