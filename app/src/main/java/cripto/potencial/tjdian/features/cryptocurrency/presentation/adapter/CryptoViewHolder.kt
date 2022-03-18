package cripto.potencial.tjdian.features.cryptocurrency.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cripto.potencial.tjdian.databinding.ViewItemCryptoBinding
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val bind = ViewItemCryptoBinding.bind(view)


    fun render(coin: CoinModel) {
        bind.text1.text = coin.name
        bind.text2.text = coin.symbol
        bind.text3.text = coin.id
      /*  bind.text4.text = coin.market_data.current_price.eur.toString()*/
    }


}