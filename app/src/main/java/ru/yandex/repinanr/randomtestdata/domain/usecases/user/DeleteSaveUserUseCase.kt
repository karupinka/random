package ru.yandex.repinanr.randomtestdata.domain.usecases.user

import ru.yandex.repinanr.randomtestdata.domain.RandomDataRepository
import javax.inject.Inject

class DeleteSaveUserUseCase @Inject constructor(
    val repository: RandomDataRepository
) {
    suspend operator fun invoke(id: Long) = repository.deleteSaveUser(id)
}