package ru.yandex.repinanr.randomtestdata.domain.usecases.user

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class GetSaveUsersUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveUsers()
}