package cripto.potencial.tjdian.features.login.domain

import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val sessionRepository: SessionRepository) {
    suspend fun execute(): Result<UserModel> = sessionRepository.getUserLogged()
}