package cripto.potencial.tjdian.features.cryptocurrency.app.presentation

sealed class UiState<out T> where T : Any? {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val error: Throwable) : UiState<Nothing>()
}