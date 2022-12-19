package ru.yandex.repinanr.domain.usecases.user

import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import javax.inject.Inject

class GetSaveUsersUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke() = repository.getSaveUsers()
}