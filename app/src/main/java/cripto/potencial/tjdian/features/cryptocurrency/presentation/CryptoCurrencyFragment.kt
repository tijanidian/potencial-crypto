package cripto.potencial.tjdian.features.cryptocurrency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cripto.potencial.tjdian.databinding.FragmentCurrencyCryptoBinding
import cripto.potencial.tjdian.features.cryptocurrency.app.presentation.UiState
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.presentation.adapter.CryptoAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CryptoCurrencyFragment @Inject constructor() : Fragment() {
    private lateinit var binding: FragmentCurrencyCryptoBinding

    private val viewModelCrypto: CryptoCurrencyViewModel by viewModels()

    @Inject
    lateinit var eventAdapter: CryptoAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyCryptoBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewStateObserver()
        viewModelCrypto.loadCoins()
    }
    private fun setupView() {
        binding.coinList.adapter = eventAdapter
        binding.coinList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.coinList.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )


    }
    private fun setupViewStateObserver() {
        val observer = Observer<UiState<List<CoinModel>>> {
            when (it) {
                is UiState.Loading -> showLoading()
                is UiState.Success -> loadEvents(it.data)
                is UiState.Error -> showEventError()
            }
        }
        viewModelCrypto.eventUIState.observe(this.viewLifecycleOwner, observer)
    }
    private fun showLoading() {
    }
    private fun loadEvents(events: List<CoinModel>) {
        eventAdapter.submitList(events)
    }
    private fun showEventError() {

    }

    companion object {
        fun createInstance() = CryptoCurrencyFragment()
    }

}