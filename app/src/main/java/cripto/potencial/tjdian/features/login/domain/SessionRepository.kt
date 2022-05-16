package cripto.potencial.tjdian.features.login.domain



interface SessionRepository {
    suspend fun getUserLogged(): Result<UserModel>
    suspend fun closeSession(): Result<Boolean>
    suspend fun deleteUserAccount(): Result<Boolean>
}