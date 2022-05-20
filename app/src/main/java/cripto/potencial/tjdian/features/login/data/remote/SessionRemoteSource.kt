package cripto.potencial.tjdian.features.login.data.remote

import android.content.Context
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import cripto.potencial.tjdian.app.domain.ErrorApp
import cripto.potencial.tjdian.features.login.domain.UserModel

import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject


class SessionRemoteSource @Inject constructor(@ApplicationContext private val context: Context) {

    suspend fun getUserLogged(): Result<UserModel> = withContext(Dispatchers.IO) {
        try {
            val user = FirebaseAuth.getInstance().currentUser
            user?.let {
                //TODO Tijani, no podemos añadir "desconocido"
                Result.success(
                    UserModel(
                        it.uid,
                        it.displayName,
                        it.email,
                        it.photoUrl?.toString()
                    )
                )
            } ?: run {
                Result.failure(ErrorApp.UserLogInError)
            }
        } catch (ex: Exception) {
            Result.failure(ErrorApp.DataError)
        }
    }

    suspend fun deleteUserAccount(): Result<Boolean> = withContext(Dispatchers.IO) {
        try {
            AuthUI.getInstance().delete(context).await()
            Result.success(true)
        } catch (ex: Exception) {
            Result.failure(ErrorApp.DataError)
        }
    }

    suspend fun closeSession(): Result<Boolean> = withContext(Dispatchers.IO) {
        try {
            AuthUI.getInstance()
                .signOut(context)
                .await()
            Result.success(true)
        } catch (ex: Exception) {
            Result.failure(ErrorApp.DataError)
        }
    }
}