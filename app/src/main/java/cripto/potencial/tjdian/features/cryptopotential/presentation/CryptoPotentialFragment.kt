package cripto.potencial.tjdian.features.cryptopotential.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cripto.potencial.tjdian.databinding.FragmentPotentialCryptoBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CryptoPotentialFragment @Inject constructor() : Fragment() {

    private lateinit var binding: FragmentPotentialCryptoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPotentialCryptoBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object{
        fun createInstance()= CryptoPotentialFragment()
    }
}