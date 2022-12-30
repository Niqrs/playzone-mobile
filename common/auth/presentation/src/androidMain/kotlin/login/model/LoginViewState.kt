package login.model

data class LoginViewState(
    val login: String = "",
    val password: String = "",
    val isSending: Boolean = false,
    val passwordHidden: Boolean = true
)
