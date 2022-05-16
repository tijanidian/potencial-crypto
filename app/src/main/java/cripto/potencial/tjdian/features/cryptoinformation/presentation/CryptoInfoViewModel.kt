package cripto.potencial.tjdian.features.cryptoinformation.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cripto.potencial.tjdian.app.presentation.UiState
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel
import cripto.potencial.tjdian.features.cryptoinformation.domain.GetDescriptionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoInfoViewModel @Inject constructor(private val getDescriptions:GetDescriptionUseCase):ViewModel() {

    val cryptoInfoUIState: LiveData<UiState<List<DescriptionModel>>>
        get() = _cryptoInfoUIState

    private val _cryptoInfoUIState: MutableLiveData<UiState<List<DescriptionModel>>> by lazy {
        MutableLiveData<UiState<List<DescriptionModel>>>()
    }

    fun loadDescriptions() {
        _cryptoInfoUIState.value = UiState.Loading
        viewModelScope.launch(Dispatchers.Main) {
            getDescriptions.execute().fold({ eventSuccess(it) }, { eventFailure(it) })
        }
    }

    private fun eventSuccess(items: List<DescriptionModel>) {
        _cryptoInfoUIState.value = UiState.Success(items)
    }

    private fun eventFailure(throwable: Throwable) {
        _cryptoInfoUIState.value = UiState.Error(throwable)
    }

}