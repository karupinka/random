package ru.yandex.repinanr.randomtestdata.domain.repository

import ru.yandex.repinanr.data.remote.RandomDataService
import ru.yandex.repinanr.data.room.address.AddressDao
import ru.yandex.repinanr.data.room.bank.BankDao
import ru.yandex.repinanr.data.room.card.CardDao
import ru.yandex.repinanr.data.room.user.UserDao
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import ru.yandex.repinanr.randomtestdata.domain.mapper.RandomDataMapper
import ru.yandex.repinanr.randomtestdata.domain.model.AddressModel
import ru.yandex.repinanr.randomtestdata.domain.model.BankModel
import ru.yandex.repinanr.randomtestdata.domain.model.CreditCardModel
import ru.yandex.repinanr.randomtestdata.domain.model.UserModel
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

    suspend override fun getSaveUsers() =
        mapper.mapListUserEntityToListUserModel(userDao.getAllUsers())

    override suspend fun getSaveUser(id: Long): UserModel? {
        userDao.getUser(id)?.let {
            return mapper.mapUserEntityToUserModel(it)
        }
        return null
    }

    override suspend fun saveUser(user: UserModel) {
        userDao.insertUser(mapper.mapUserModelToUserEntity(user))
    }

    override suspend fun deleteSaveUser(id: Long) {
        userDao.deleteUser(id)
    }

    override suspend fun getBank() = mapper.mapBankResponseToBankModel(service.getBank())

    override suspend fun getSaveBanks(): List<BankModel> =
        mapper.mapListBankEntityToListBankModel(bankDao.getAllBanks())

    override suspend fun getSaveBank(id: Long): BankModel? {
        bankDao.getBank(id)?.let {
            return mapper.mapBankEntityToBankModel(it)
        }
        return null
    }

    override suspend fun saveBank(bank: BankModel) {
        bankDao.insertBank(mapper.mapBankModelToBankEntity(bank))
    }

    override suspend fun deleteSaveBank(id: Long) {
        bankDao.deleteBank(id)
    }

    override suspend fun getCreditCard() =
        mapper.mapCreditCardResponseToCreditCardModel(service.getCreditCard())

    override suspend fun getSaveCreditCards(): List<CreditCardModel> =
        mapper.mapListCreditCardEntityToListCreditCardModel(creditCardDao.getAllCard())

    override suspend fun getSaveCreditCard(id: Long): CreditCardModel? {
        creditCardDao.getCard(id)?.let {
            return mapper.mapCreditCardEntityToCreditCardModel(it)
        }
        return null
    }

    override suspend fun saveCreditCard(creditCard: CreditCardModel) {
        creditCardDao.insertCard(mapper.mapCreditCardModelToCreditCardEntity(creditCard))
    }

    override suspend fun deleteSaveCreditCard(id: Long) {
        creditCardDao.deleteCard(id)
    }

    override suspend fun getAddress() =
        mapper.mapAddressResponseToAddressModel(service.getAddresses())

    override suspend fun getSaveAddresses(): List<AddressModel> =
        mapper.mapListAddressEntityToListAddressModel(addressDao.getAllAddresses())

    override suspend fun getSaveAddress(id: Long): AddressModel? {
        addressDao.getAddress(id)?.let {
            return mapper.mapAddressEntityToAddressModel(it)
        }
        return null
    }

    override suspend fun saveAddress(address: AddressModel) {
        addressDao.insertAddress(mapper.mapAddressModelToAddressEntity(address))
    }

    override suspend fun deleteSaveAddress(id: Long) {
        addressDao.deleteAddress(id)
    }
}