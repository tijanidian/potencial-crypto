package cripto.potencial.tjdian.features.cryptocurrency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cripto.potencial.tjdian.app.presentation.UiState
import cripto.potencial.tjdian.features.cryptocurrency.domain.CoinModel
import cripto.potencial.tjdian.features.cryptocurrency.domain.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoCurrencyViewModel @Inject constructor(
    private val getCoins: GetCoinsUseCase
) : ViewModel() {

    val coinViewState: LiveData<UiState<List<CoinModel>>>
        get() = _coinViewState

    private val _coinViewState: MutableLiveData<UiState<List<CoinModel>>> by lazy {
        MutableLiveData<UiState<List<CoinModel>>>()
    }

    fun loadCoins() {
        _coinViewState.value = UiState.Loading
        viewModelScope.launch(Dispatchers.Main) {
            getCoins.execute().fold({ coinSuccess(it) }, { coinFailure(it) })
        }
    }

    private fun coinSuccess(items: List<CoinModel>) {
        _coinViewState.value = UiState.Success(items)
    }

    private fun coinFailure(throwable: Throwable) {
        _coinViewState.value = UiState.Error(throwable)
    }

}