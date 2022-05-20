package cripto.potencial.tjdian.features.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cripto.potencial.tjdian.features.login.domain.DeleteAccountUseCase
import cripto.potencial.tjdian.features.login.domain.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSettingsViewModel @Inject constructor(
    private val deleteAccountUseCase: DeleteAccountUseCase,
    private val singOutUseCase: SignOutUseCase,
) : ViewModel() {

    fun removeAccountUser() {
        viewModelScope.launch(Dispatchers.Main) {
            deleteAccountUseCase.execute()
        }
    }

    fun singOutUser() {
        viewModelScope.launch(Dispatchers.Main) {
            singOutUseCase.execute()
        }
    }


}