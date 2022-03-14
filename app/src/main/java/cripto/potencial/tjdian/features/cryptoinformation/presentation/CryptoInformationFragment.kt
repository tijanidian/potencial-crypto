package cripto.potencial.tjdian.features.cryptoinformation.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cripto.potencial.tjdian.databinding.FragmentInformationCryptoBinding

class CryptoInformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationCryptoBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationCryptoBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object{
        fun createInstance()= CryptoInformationFragment()
    }
}