package ru.yandex.repinanr.randomtestdata.domain.usecases.address

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class GetSaveAddressesUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveAddresses()
}