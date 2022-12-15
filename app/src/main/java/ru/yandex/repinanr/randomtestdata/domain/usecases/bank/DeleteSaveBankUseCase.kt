package ru.yandex.repinanr.randomtestdata.domain.usecases.bank

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class DeleteSaveBankUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteSaveBank(id)
}