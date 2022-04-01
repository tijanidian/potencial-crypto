package cripto.potencial.tjdian.app.domain

sealed class ErrorApp : Throwable() {
    object DataError : ErrorApp()
    object NetworkConnectionError : ErrorApp()
    object ServerError : ErrorApp()
    object UserLogInError : ErrorApp()

}