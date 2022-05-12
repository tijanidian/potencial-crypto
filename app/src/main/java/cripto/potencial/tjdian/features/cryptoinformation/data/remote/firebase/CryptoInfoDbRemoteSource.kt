package cripto.potencial.tjdian.features.cryptoinformation.data.remote.firebase

import com.google.firebase.database.DatabaseReference
import cripto.potencial.tjdian.app.domain.ErrorApp
import cripto.potencial.tjdian.features.cryptoinformation.data.remote.CryptoInfoRemoteSource
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoInfoDbRemoteSource @Inject constructor(private val db: DatabaseReference) :
    CryptoInfoRemoteSource {

    override suspend fun getDescription(): Result<List<DescriptionModel>> = withContext(Dispatchers.IO) {
        val events = mutableListOf<DescriptionModel>()
        try {
            val dataSnapshot = db
                .child("events")
                .get()
                .await()
            dataSnapshot.children.forEach {
                it.getValue(CryptoInfoRemoteModel::class.java)?.let {
                    events.add(CryptoInfoRemoteModel.toModel(it))
                }
            }
            Result.success(events)
        } catch (ex: Exception) {
            Result.failure(ErrorApp.ServerError)
        }
    }


}

