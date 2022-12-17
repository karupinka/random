package ru.yandex.repinanr.randomtestdata.domain.usecases

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import ru.yandex.repinanr.randomtestdata.domain.model.*
import javax.inject.Inject

class SaveDataUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(dataModel: DataModel) {
        when(dataModel) {
            is AddressModel -> repository.saveAddress(dataModel)
            is BankModel -> repository.saveBank(dataModel)
            is CreditCardModel -> repository.saveCreditCard(dataModel)
            is UserModel -> repository.saveUser(dataModel)
            else -> throw ClassCastException("Wrong class")
        }
    }
}