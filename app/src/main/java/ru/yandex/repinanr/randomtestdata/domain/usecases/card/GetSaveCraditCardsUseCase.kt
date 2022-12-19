package ru.yandex.repinanr.domain.usecases.card

import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import javax.inject.Inject

class GetSaveCraditCardsUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveCreditCards()
}