package cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel

import cripto.potencial.tjdian.features.cryptocurrency.domain.ImageModel

data class Image(
    val large: String,
    val small: String,
    val thumb: String
){
    fun toModel():ImageModel= ImageModel(large, small, thumb)
}