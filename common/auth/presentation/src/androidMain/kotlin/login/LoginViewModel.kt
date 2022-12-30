package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import login.model.LoginAction
import login.model.LoginEvent
import login.model.LoginViewState

//TODO: Ask about SharedFlow and Chanel in ViewModel
class LoginViewModel: BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState()
) {
    private val authRepository: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.LoginChange -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.PasswordChange -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.RegistrationCLick -> openRegistration()
            LoginEvent.PasswordShowClick -> changePasswordVisibility()
        }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
            viewState = try {
                val response = authRepository.login(viewState.login, viewState.password)
                if (response.token.isNotBlank()) {
                    viewState.copy(login = "", password = "", isSending = false)
                } else {
                    viewState.copy(isSending = false)
                }
            } catch (_: Exception) {
                viewState.copy(isSending = false)
            }
        }
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(
            login = value
        )
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }
}
