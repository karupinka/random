package ru.yandex.repinanr.randomtestdata.domain.usecases.bank

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class GetSaveBanksUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveBanks()
}