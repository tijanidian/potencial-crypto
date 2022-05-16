package cripto.potencial.tjdian.features.login.domain

data class UserModel(
    val userId: String,
    val name: String? = null,
    val email: String? = null,
    val urlPhoto: String? = null
)