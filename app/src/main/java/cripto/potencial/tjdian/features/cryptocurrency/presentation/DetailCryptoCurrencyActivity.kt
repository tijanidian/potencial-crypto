package cripto.potencial.tjdian.features.cryptocurrency.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.lifecycle.Observer
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.app.extensions.loadUrl
import cripto.potencial.tjdian.databinding.ActivityDetailCryptoCurrencyBinding
import dagger.hilt.android.AndroidEntryPoint

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

    private fun render(coinModel: CryptoDetailViewState) {
        hideLoading()
        renderText(coinModel)
        renderImage(coinModel)
        renderLink(coinModel)
        renderRatingBar(coinModel)
    }

    private fun renderText(coinModel: CryptoDetailViewState) {
        binding.labelCryptoName.text = coinModel.name
        binding.labelCryptoSymbol.text = coinModel.symbol

        binding.labelMarketCap.text =
            getString(R.string.market_cap_detail, coinModel.market_data.market_cap.eur.toString())
        binding.labelCryptoPriceEur.text = getString(
            R.string.crypto_price_detail,
            coinModel.market_data.current_price.eur.toString()
        )
        binding.labelTotalSupply.text =
            getString(R.string.total_supply_detail, coinModel.market_data.total_supply)
        binding.labelCryptoRank.text =
            getString(R.string.empty_rank_detail, coinModel.market_data.market_cap_rank.toString())

        binding.labelCountryOrigin.text = getString(R.string.country_name, coinModel.country_origin)
        binding.labelHashingAlgorithm.text =
            getString(R.string.type_hash_name_coin, coinModel.hashing_algorithm)
        binding.labelBlockTimeInMinutes.text =
            getString(R.string.time_block, coinModel.block_time_in_minutes.toString())


        //Titles
        binding.labelCryptoInfoTitle.text = getString(R.string.title_name_coin, coinModel.name)
        binding.labelCryptoInfoTitle.text =
            getString(R.string.title_public_interest_score, coinModel.name)
        binding.labelCryptoTitleDescription.text =
            getString(R.string.title_description_coin, coinModel.name)



        when {
            coinModel.market_data.total_supply == null -> binding.labelTotalSupply.text =
                getString(R.string.empty_info)
            coinModel.description.en=="" -> binding.labelCurrentDescreption.text =
                getString(R.string.empty_info)
            coinModel.country_origin == "" -> binding.labelCountryOrigin.text =
                getString(R.string.empty_info)
        }

    }

    private fun renderImage(coinModel: CryptoDetailViewState) {
        binding.labelCryptoImage.loadUrl(coinModel.image.large)
    }

    private fun renderLink(coinModel: CryptoDetailViewState) {

        binding.labelCryptoTitleDescription.movementMethod = LinkMovementMethod.getInstance()
        binding.labelCurrentDescreption.text = HtmlCompat.fromHtml(
            coinModel.description.en,
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
    }

    private fun renderRatingBar(coinModel: CryptoDetailViewState) {
        binding.publicInterestScore.rating = coinModel.public_interest_score.toFloat()
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