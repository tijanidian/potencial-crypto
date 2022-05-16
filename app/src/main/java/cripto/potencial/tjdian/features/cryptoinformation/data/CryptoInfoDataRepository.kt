package cripto.potencial.tjdian.features.cryptoinformation.data

import cripto.potencial.tjdian.features.cryptoinformation.data.remote.CryptoInfoRemoteSource
import cripto.potencial.tjdian.features.cryptoinformation.domain.CryptoInfoRepository
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel
import javax.inject.Inject

class CryptoInfoDataRepository @Inject constructor( private val remoteSource:CryptoInfoRemoteSource):CryptoInfoRepository {

    override suspend fun fetchDescriptions(): Result<List<DescriptionModel>> = remoteSource.getDescription()

}