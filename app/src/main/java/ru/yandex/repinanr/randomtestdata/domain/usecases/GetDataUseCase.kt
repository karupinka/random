package ru.yandex.repinanr.randomtestdata.domain.usecases

import ru.yandex.repinanr.domain.model.DataModel
import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import ru.yandex.repinanr.save.domain.DataTypes
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