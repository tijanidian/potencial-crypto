package cripto.potencial.tjdian.features.cryptopotential.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cripto.potencial.tjdian.databinding.FragmentPotentialCryptoBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.roundToInt

@AndroidEntryPoint
class CryptoPotentialFragment @Inject constructor() : Fragment() {

    private lateinit var binding: FragmentPotentialCryptoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPotentialCryptoBinding.inflate(inflater, container, false)
        calculatePotentialCoin2()
        resetPotentialCoin()
        return binding.root

    }


    //Dividimos market cap entre su max supply y colocamos las monedas para calcular
    private fun calculatePotentialCoin() {
        binding.labelResult.text = "Rellena todos los campos"


        val marketCap = binding.editMarketCap.inputType
        val totalSupply = binding.editTotalSupplu.inputType
        val coins = binding.editCoins.inputType

        if (marketCap==null || totalSupply==null|| coins==null) {
            binding.labelResult.text = "Rellena todos los campos"
        } else {

            binding.actionCalculatePotential.setOnClickListener {
                val result=(marketCap/totalSupply)*coins
                binding.labelResult.text= "${result} $"
            }
        }

    }

    private fun calculatePotentialCoin2() {



            binding.actionCalculatePotential.setOnClickListener {
                val value1= binding.editMarketCap.text.toString().toDouble()
                val value2= binding.editTotalSupplu.text.toString().toDouble()
                val value3 = binding.editCoins.text.toString().toDouble()


                val calculatedValue = value1 / value2 * value3
                val roundoff = (calculatedValue * 100.0).roundToInt() / 100.0
                binding.labelResult.text = roundoff.toString()


        }


    }

    private fun resetPotentialCoin() {
        binding.actionResetPotential.setOnClickListener {
            binding.editMarketCap.setText("")
            binding.editTotalSupplu.setText("")
            binding.editCoins.setText("")
            binding.labelResult.text=""
        }
    }


    companion object {
        fun createInstance() = CryptoPotentialFragment()
    }

}


