package cripto.potencial.tjdian.features.login.domain

import javax.inject.Inject

class SignOutUseCase @Inject constructor(private val sessionRepository: SessionRepository) {
    suspend fun execute(): Result<Boolean> = sessionRepository.closeSession()
}