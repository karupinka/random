package ru.yandex.repinanr.domain.usecases.user

import ru.yandex.repinanr.randomtestdata.domain.repository.RandomDataRepository
import javax.inject.Inject

class DeleteSaveUserUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteSaveUser(id)
}