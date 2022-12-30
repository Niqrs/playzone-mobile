package login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.model.LoginEvent
import theme.Theme

@Composable
fun LoginScreen() {
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state by viewModel.viewStates().observeAsState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login Now",
                color = Theme.colors.thirdTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Welcome back to PlayZone! Enter your email address and your password to enjoy the latest features of PlayZone",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Theme.colors.hintTextColor
            )

            Spacer(modifier = Modifier.height(50.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                value = state.login,
                enabled = !state.isSending,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF1F2430),
                    textColor = Color(0xFF696C75),
                    cursorColor = Theme.colors.highlightTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(text = "Your login", color = Theme.colors.hintTextColor)
                },
                shape = RoundedCornerShape(10.dp),
                onValueChange = {
                    viewModel.obtainEvent(LoginEvent.LoginChange(it))
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                value = state.password,
                enabled = !state.isSending,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF1F2430),
                    textColor = Color(0xFF696C75),
                    cursorColor = Theme.colors.highlightTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                visualTransformation = if (state.passwordHidden) {
                    PasswordVisualTransformation('*')
                } else {
                    VisualTransformation.None
                },
                placeholder = {
                    Text(text = "Your password", color = Theme.colors.hintTextColor)
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            viewModel.obtainEvent(LoginEvent.PasswordShowClick)
                        }
                    ) {
                        Icon(
                            imageVector = if (state.passwordHidden) {
                                Icons.Outlined.Clear
                            } else {
                                Icons.Filled.Lock
                            },
                            contentDescription = "Password hidden",
                            tint = Theme.colors.hintTextColor
                        )
                    }
                },
                shape = RoundedCornerShape(10.dp),
                onValueChange = {
                    viewModel.obtainEvent(LoginEvent.PasswordChange(it))
                }
            )

            Spacer(modifier = Modifier.height(84.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Theme.colors.primaryAction
                ),
                enabled = !state.isSending,
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    viewModel.obtainEvent(LoginEvent.LoginClick)
                }
            ) {
                Text(
                    text = "Login Now",
                    color = Theme.colors.primaryTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}