package cripto.potencial.tjdian.features.cryptocurrency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cripto.potencial.tjdian.features.cryptocurrency.domain.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailCryptoCurrencyViewModel @Inject constructor(private val getCoinUseCase: GetCoinUseCase): ViewModel() {

    val coinViewState: LiveData<CryptoDetailViewState>
        get() = _coinViewState

    private val _coinViewState: MutableLiveData<CryptoDetailViewState> by lazy {
        MutableLiveData<CryptoDetailViewState>()
    }

    fun loadCoin(coinId: String) {
        viewModelScope.launch(Dispatchers.Main) {
            val alert = getCoinUseCase.execute(coinId)
            alert?.let {
                _coinViewState.postValue(CryptoDetailViewState.fromDetailModel(it))
            }
        }
    }


}