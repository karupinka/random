package ru.yandex.repinanr.randomtestdata.domain.usecases

import ru.yandex.repinanr.randomtestdata.data.model.common.*
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class SaveDataUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(dataModel: DataModel) {
        when(dataModel) {
            is AddressModel -> repository.saveAddress(dataModel)
            is BankModel -> repository.saveBank(dataModel as BankModel)
            is CreditCardModel -> repository.saveCreditCard(dataModel)
            is UserModel -> repository.saveUser(dataModel)
            else -> throw ClassCastException("Wrong class")
        }
    }
}