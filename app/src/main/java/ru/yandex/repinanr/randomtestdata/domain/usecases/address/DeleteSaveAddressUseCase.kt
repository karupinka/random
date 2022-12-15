package ru.yandex.repinanr.randomtestdata.domain.usecases.address

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class DeleteSaveAddressUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteSaveAddress(id)
}