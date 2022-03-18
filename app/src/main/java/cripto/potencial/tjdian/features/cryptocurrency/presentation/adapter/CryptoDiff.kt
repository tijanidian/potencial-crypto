package cripto.potencial.tjdian.features.cryptocurrency.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

class CryptoDiff : DiffUtil.ItemCallback<CoinModel>(){


    override fun areItemsTheSame(oldItem: CoinModel, newItem: CoinModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoinModel, newItem: CoinModel): Boolean {
        return oldItem == newItem
    }
}