package ru.yandex.repinanr.randomtestdata.domain.usecases

import ru.yandex.repinanr.domain.model.DataModel
import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import ru.yandex.repinanr.save.domain.DataTypes
import javax.inject.Inject

class GetSaveDataUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long, type: DataTypes): DataModel? {
        return when(type) {
            DataTypes.ADDRESS -> repository.getSaveAddress(id)
            DataTypes.BANK -> repository.getSaveBank(id)
            DataTypes.CREDIT_CARD -> repository.getSaveCreditCard(id)
            DataTypes.USER -> repository.getSaveUser(id)
        }
    }
}