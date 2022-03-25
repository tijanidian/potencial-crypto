package cripto.potencial.tjdian.features.cryptocurrency.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html.FROM_HTML_MODE_LEGACY
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.app.extensions.loadUrl
import cripto.potencial.tjdian.databinding.ActivityDetailCryptoCurrencyBinding
import cripto.potencial.tjdian.features.cryptoinformation.presentation.CryptoInformationFragment
import cripto.potencial.tjdian.features.cryptopotential.presentation.CryptoPotentialFragment
import cripto.potencial.tjdian.features.settings.presentation.SettingsFragment
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.delimiterOffset

@AndroidEntryPoint
class DetailCryptoCurrencyActivity : AppCompatActivity() {

    private val binding: ActivityDetailCryptoCurrencyBinding by lazy {
        ActivityDetailCryptoCurrencyBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailCryptoCurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
        setupObservers()
        viewModel.loadCoin(getCoinId())

    }

    private fun setUpView() {
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.customToolbar.mainBar)
        supportActionBar?.title = getString(R.string.action_crypto)
    }


    private fun getCoinId(): String = intent.extras!!.getString(KEY_COIN_ID, "1")

    private fun setupObservers() {
        showLoading()
        val nameObserver = Observer<CryptoDetailViewState> { alert ->
            render(alert)
        }
        viewModel.coinViewState.observe(this, nameObserver)
    }

    private fun render(coin: CryptoDetailViewState) {
        hideLoading()
        renderText(coin)

    }

    @SuppressLint("WrongConstant")
    private fun renderText(coin: CryptoDetailViewState) {
        binding.labelCryptoName.text = coin.name
        binding.labelCryptoSymbol.text=coin.symbol
        binding.labelCurrentDescreption.text=HtmlCompat.fromHtml(coin.description.en,FROM_HTML_MODE_LEGACY)
        binding.labelCryptoImage.loadUrl(coin.image.large)

        binding.labelMarketCap.text=getString(R.string.market_cap_detail, coin.market_data.market_cap.eur.toString())
        binding.labelCryptoPriceEur.text=getString(R.string.crypto_price_detail, coin.market_data.current_price.eur.toString())
        binding.labelTotalSupply.text= getString(R.string.total_supply_detail, coin.market_data.total_supply)
        binding.labelCryptoRank.text=  getString(R.string.empty_rank_detail, coin.market_data.market_cap_rank.toString())

        binding.labelCryptoInfoTitle.text= getString(R.string.title_name_coin, coin.name)
        binding.labelCryptoInfoTitle.text= getString(R.string.title_public_interest_score, coin.name)
        binding.labelCryptoTitleDescription.text= getString(R.string.title_description_coin, coin.name)

        if(coin.market_data.total_supply==null){
            binding.labelTotalSupply.text=getString(R.string.empty_supply)
        }

        binding.publicInterestScore.rating= coin.public_interest_score.toFloat()


    }

    private fun showLoading() {
       binding.viewProgressIndicator.show()
    }
    private fun hideLoading() {
        binding.viewProgressIndicator.hide()
    }

    companion object {
        const val KEY_COIN_ID = "key_coin_id"
        fun createIntent(context: Context, coinId: String) =
            Intent(context, DetailCryptoCurrencyActivity::class.java).also { intent ->
                intent.putExtra(
                    KEY_COIN_ID, coinId
                )
            }
    }
}