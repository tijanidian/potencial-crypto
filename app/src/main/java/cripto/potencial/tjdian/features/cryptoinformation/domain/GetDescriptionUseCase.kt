package cripto.potencial.tjdian.features.cryptoinformation.domain

import javax.inject.Inject

class GetDescriptionUseCase @Inject constructor(private val repository:CryptoInfoRepository) {

    suspend fun execute():Result<List<DescriptionModel>> = repository.fetchDescriptions()

}