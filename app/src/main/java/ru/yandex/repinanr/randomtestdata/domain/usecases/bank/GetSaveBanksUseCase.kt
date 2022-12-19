package ru.yandex.repinanr.domain.usecases.bank

import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import javax.inject.Inject

class GetSaveBanksUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveBanks()
}