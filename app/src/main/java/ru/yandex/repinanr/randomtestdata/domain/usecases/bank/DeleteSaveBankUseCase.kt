package ru.yandex.repinanr.domain.usecases.bank

import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import javax.inject.Inject

class DeleteSaveBankUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteSaveBank(id)
}