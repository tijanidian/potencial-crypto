package cripto.potencial.tjdian.features.cryptoinformation.data.remote

import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel


interface CryptoInfoRemoteSource {
    suspend fun getDescription():Result<List< DescriptionModel>>
}