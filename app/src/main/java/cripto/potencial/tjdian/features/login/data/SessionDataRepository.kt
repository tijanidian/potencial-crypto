package cripto.potencial.tjdian.features.login.data


import cripto.potencial.tjdian.features.login.data.remote.SessionRemoteSource
import cripto.potencial.tjdian.features.login.domain.SessionRepository
import cripto.potencial.tjdian.features.login.domain.UserModel
import javax.inject.Inject

class SessionDataRepository @Inject constructor(private val remote: SessionRemoteSource) :
    SessionRepository {

    override suspend fun getUserLogged(): Result<UserModel> = remote.getUserLogged()

    override suspend fun closeSession(): Result<Boolean> = remote.closeSession()

    override suspend fun deleteUserAccount(): Result<Boolean> = remote.deleteUserAccount()


}