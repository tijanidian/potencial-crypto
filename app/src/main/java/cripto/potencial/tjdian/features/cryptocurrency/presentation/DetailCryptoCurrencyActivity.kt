package cripto.potencial.tjdian.features.cryptocurrency.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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
        setupObservers()
        viewModel.loadCoin(getCoinId())
    }

    fun getCoinId(): String = intent.extras!!.getString(KEY_COIN_ID, "1")

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

    private fun renderText(coin: CryptoDetailViewState) {
        binding.labelCryptoName.text = coin.name
    }

    private fun showLoading() {
       binding.viewProgressIndicator.show()
    }
    private fun hideLoading() {
        binding.viewProgressIndicator.hide()
    }


    companion object {
        val KEY_COIN_ID = "key_coin_id"
        fun createIntent(context: Context, coinId: String) =
            Intent(context, DetailCryptoCurrencyActivity::class.java).also { intent ->
                intent.putExtra(
                    KEY_COIN_ID, coinId
                )
            }
    }
}