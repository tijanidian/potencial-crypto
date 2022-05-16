package cripto.potencial.tjdian.features.cryptoinformation.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel
import javax.inject.Inject

class CryptoInfoAdapter @Inject constructor() :
    androidx.recyclerview.widget.ListAdapter<DescriptionModel, CryptoInfoviewHolder>(
        AsyncDifferConfig.Builder(
            CryptoInfoDiff()
        ).build()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoInfoviewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_item_info_crypto, parent, false)
        return CryptoInfoviewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoInfoviewHolder, position: Int) {
        holder.render(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}