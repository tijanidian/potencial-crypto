package cripto.potencial.tjdian.features.cryptocurrency.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.databinding.ViewItemCryptoBinding
import cripto.potencial.tjdian.app.extensions.loadUrl
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel

class CryptoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemCryptoBinding.bind(view)



    fun render(coinModel: CoinModel) {
        binding.labelCryptoName.text=coinModel.name
        binding.cryptpImage.loadUrl(coinModel.image.small)
        binding.labelCryptoSymbol.text=view.context.getString(R.string.crypto_symbol, coinModel.symbol.uppercase())
        binding.labelCryptoPrice.text=view.context.getString(R.string.crypto_price, coinModel.market_data.current_price.eur.toString())
        binding.labelCryptoMarketCap.text= view.context.getString(R.string.market_cap, coinModel.market_data.market_cap.eur.toString())
        binding.labelCryptoTotalSupply.text=view.context.getString(R.string.total_supply, coinModel.market_data.total_supply)

        if (coinModel.market_data.total_supply==null){
            binding.labelCryptoTotalSupply.text= view.context.getString(R.string.empty_supply)
        }
    }



}