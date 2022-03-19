package cripto.potencial.tjdian.features.cryptocurrency.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter

import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import javax.inject.Inject


class CryptoAdapter @Inject constructor():

    ListAdapter<CoinModel, CryptoViewHolder>(AsyncDifferConfig.Builder(CryptoDiff()).build()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_item_crypto, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.render(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}