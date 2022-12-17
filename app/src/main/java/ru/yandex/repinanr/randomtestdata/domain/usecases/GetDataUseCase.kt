package ru.yandex.repinanr.randomtestdata.domain.usecases

import ru.yandex.repinanr.randomtestdata.domain.DataTypes
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import ru.yandex.repinanr.randomtestdata.domain.model.DataModel
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(type: DataTypes): DataModel {
        return when(type) {
            DataTypes.ADDRESS -> repository.getAddress()
            DataTypes.BANK -> repository.getBank()
            DataTypes.CREDIT_CARD -> repository.getCreditCard()
            DataTypes.USER -> repository.getUser()
        }
    }
}