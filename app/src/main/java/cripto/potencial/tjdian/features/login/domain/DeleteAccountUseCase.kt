package cripto.potencial.tjdian.features.login.domain

import javax.inject.Inject

class DeleteAccountUseCase @Inject constructor(private val sessionRepository: SessionRepository) {
    suspend fun execute(): Result<Boolean> = sessionRepository.deleteUserAccount()
}