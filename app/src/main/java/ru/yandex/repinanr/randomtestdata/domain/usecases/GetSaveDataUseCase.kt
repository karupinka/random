package ru.yandex.repinanr.randomtestdata.domain.usecases

import ru.yandex.repinanr.randomtestdata.data.model.common.DataModel
import ru.yandex.repinanr.randomtestdata.domain.DataTypes
import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
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