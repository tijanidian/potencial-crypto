package cripto.potencial.tjdian.features.cryptocurrency.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cripto.potencial.tjdian.features.cryptocurrency.domain.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoCurrencyViewModel @Inject constructor(
    private val getCoins: GetCoinsUseCase
) : ViewModel() {

    fun loadCoins() {
        viewModelScope.launch(Dispatchers.Main) {
            getCoins.execute()
        }
    }

}