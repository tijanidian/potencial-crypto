package cripto.potencial.tjdian.features.cryptoinformation.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cripto.potencial.tjdian.databinding.ViewItemInfoCryptoBinding
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel

class CryptoInfoviewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemInfoCryptoBinding.bind(view)


    fun render(descriptionModel:DescriptionModel){
        binding.cryptoInfoTitle.text=descriptionModel.id
        binding.cryptoInfoDescription.text=descriptionModel.description
    }
}