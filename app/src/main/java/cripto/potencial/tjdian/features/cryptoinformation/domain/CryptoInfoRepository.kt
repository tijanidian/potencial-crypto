package cripto.potencial.tjdian.features.cryptoinformation.domain

interface CryptoInfoRepository {

    suspend fun fetchDescriptions():Result<List<DescriptionModel>>

}