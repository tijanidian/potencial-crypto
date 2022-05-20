package cripto.potencial.tjdian.features.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cripto.potencial.tjdian.app.presentation.UiState
import cripto.potencial.tjdian.features.login.domain.GetUserUseCase
import cripto.potencial.tjdian.features.login.domain.UserModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) :
    ViewModel() {

    val appProperties: LiveData<UiState<String>>
        get() = _appProperties

    private val _appProperties: MutableLiveData<UiState<String>> by lazy {
        MutableLiveData<UiState<String>>()
    }

    val userObservable: LiveData<UiState<UserModel>>
        get() = _user

    private val _user: MutableLiveData<UiState<UserModel>> by lazy {
        MutableLiveData<UiState<UserModel>>()
    }



    fun loadUserInfo() {
        _user.value = UiState.Loading
        viewModelScope.launch(Dispatchers.Main) {
            getUserUseCase.execute().fold({ userSuccess(it) }, { userFailure(it) })
        }
    }

    private fun userSuccess(item: UserModel) {
        _user.value = UiState.Success(item)
    }

    private fun userFailure(throwable: Throwable) {
        _user.value = UiState.Error(throwable)
    }
}
