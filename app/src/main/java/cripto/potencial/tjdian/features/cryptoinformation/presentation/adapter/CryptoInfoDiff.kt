package cripto.potencial.tjdian.features.cryptoinformation.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel

class CryptoInfoDiff:DiffUtil.ItemCallback<DescriptionModel>() {
    override fun areItemsTheSame(oldItem: DescriptionModel, newItem: DescriptionModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DescriptionModel, newItem: DescriptionModel): Boolean {
        return oldItem.id == newItem.id
    }


}