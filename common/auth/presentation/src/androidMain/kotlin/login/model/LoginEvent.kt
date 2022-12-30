package login.model

sealed class LoginEvent {
    data class LoginChange(val value: String) : LoginEvent()
    data class PasswordChange(val value: String): LoginEvent()
    object PasswordShowClick : LoginEvent()
    object LoginClick : LoginEvent()
    object RegistrationCLick : LoginEvent()
    object ForgotClick: LoginEvent()
}
