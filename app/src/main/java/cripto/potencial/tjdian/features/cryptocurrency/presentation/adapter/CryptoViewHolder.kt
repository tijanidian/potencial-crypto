package cripto.potencial.tjdian.features.cryptocurrency.presentation.adapter

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.databinding.ViewItemCryptoBinding
import cripto.potencial.tjdian.app.extensions.loadUrl
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.presentation.DetailCryptoCurrencyActivity

class CryptoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemCryptoBinding.bind(view)



    fun render(coinModel: CoinModel) {
        binding.labelCryptoName.text=coinModel.name
        binding.cryptpImage.loadUrl(coinModel.image.small)
        binding.labelCryptoSymbol.text=view.context.getString(R.string.crypto_symbol, coinModel.symbol.uppercase())
        binding.labelCryptoPrice.text=view.context.getString(R.string.crypto_price, coinModel.market_data.current_price?.eur.toString())
        binding.labelCryptoMarketCap.text= view.context.getString(R.string.market_cap, coinModel.market_data.market_cap.eur.toString())
        binding.labelCryptoTotalSupply.text=view.context.getString(R.string.total_supply, coinModel.market_data.total_supply)
        itemView.setOnClickListener {
            startActivity(
                view.context,
                DetailCryptoCurrencyActivity.createIntent(view.context, coinModel.id),
                Bundle.EMPTY
            )
        }

        if (coinModel.market_data.total_supply==null){
            binding.labelCryptoTotalSupply.text= view.context.getString(R.string.empty_info)
        }
    }



}