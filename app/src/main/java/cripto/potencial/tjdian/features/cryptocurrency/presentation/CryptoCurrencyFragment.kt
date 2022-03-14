package cripto.potencial.tjdian.features.cryptocurrency.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cripto.potencial.tjdian.databinding.FragmentCurrencyCryptoBinding

class CryptoCurrencyFragment:Fragment(){
    private lateinit var binding: FragmentCurrencyCryptoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyCryptoBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object{
        fun createInstance()= CryptoCurrencyFragment()
    }

}