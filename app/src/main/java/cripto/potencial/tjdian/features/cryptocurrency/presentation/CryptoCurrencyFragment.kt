package cripto.potencial.tjdian.features.cryptocurrency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cripto.potencial.tjdian.databinding.FragmentCurrencyCryptoBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CryptoCurrencyFragment @Inject constructor() : Fragment() {
    private lateinit var binding: FragmentCurrencyCryptoBinding

    private val viewModelCrypto: CryptoCurrencyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyCryptoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelCrypto.loadCoins()
    }


    companion object {
        fun createInstance() = CryptoCurrencyFragment()
    }

}