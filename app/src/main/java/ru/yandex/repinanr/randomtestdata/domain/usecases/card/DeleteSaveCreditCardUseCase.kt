package ru.yandex.repinanr.randomtestdata.domain.usecases.card

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class DeleteSaveCreditCardUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteSaveCreditCard(id)
}