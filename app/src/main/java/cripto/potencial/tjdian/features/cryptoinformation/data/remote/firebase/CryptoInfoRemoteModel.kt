package cripto.potencial.tjdian.features.cryptoinformation.data.remote.firebase

import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel

class CryptoInfoRemoteModel {
    var description: String = ""
    var id: String = ""


    companion object {
        fun toModel(dbRemoteModel: CryptoInfoRemoteModel) = DescriptionModel(
            dbRemoteModel.description,
            dbRemoteModel.id
        )
    }

}