package ru.yandex.repinanr.randomtestdata.domain.usecases.card

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class GetSaveCraditCardsUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveCreditCards()
}