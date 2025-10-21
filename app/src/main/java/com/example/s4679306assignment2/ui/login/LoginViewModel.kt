package com.example.s4679306assignment2.ui.login

import androidx.lifecycle.*
import com.example.s4679306assignment2.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val keypass: String) : LoginState()
    data class Error(val message: String) : LoginState()
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {

    private val _state = MutableLiveData<LoginState>(LoginState.Idle)
    val state: LiveData<LoginState> = _state

    // expose field errors for the UI
    private val _usernameError = MutableLiveData<String?>(null)
    val usernameError: LiveData<String?> = _usernameError

    private val _passwordError = MutableLiveData<String?>(null)
    val passwordError: LiveData<String?> = _passwordError

    fun onUsernameChanged(value: String) {
        _usernameError.value = validateUsername(value)
    }

    fun onPasswordChanged(value: String) {
        _passwordError.value = validatePassword(value)
    }

    fun login(usernameRaw: String, passwordRaw: String) {
        val username = usernameRaw.trim()
        val password = passwordRaw.trim()

        val uErr = validateUsername(username)
        val pErr = validatePassword(password)
        _usernameError.value = uErr
        _passwordError.value = pErr

        if (uErr != null || pErr != null) {
            _state.value = LoginState.Error("Please fix the errors above")
            return
        }

        _state.value = LoginState.Loading
        viewModelScope.launch {
            try {
                // Normalize username for the API (accepts Kailash/kailash)
                val key = repo.login(username.lowercase(), password)
                _state.value = LoginState.Success(key)
            } catch (e: HttpException) {
                _state.value = when (e.code()) {
                    400, 401 -> LoginState.Error("Invalid username or wrong password")
                    in 500..599 -> LoginState.Error("Server error. Please try again.")
                    else -> LoginState.Error("Login failed (${e.code()})")
                }
            } catch (_: IOException) {
                _state.value = LoginState.Error("Network error. Check your connection.")
            } catch (e: Exception) {
                _state.value = LoginState.Error("Login failed: ${e.message ?: "Unknown error"}")
            }
        }
    }

    private fun validateUsername(u: String): String? {
        if (u.isBlank()) return "Enter your first name"
        if (!u.matches(Regex("^[A-Za-z]{2,}$"))) return "Only letters allowed"
        return null
    }

    private fun validatePassword(p: String): String? {
        if (p.isBlank()) return "Enter your student ID"
        if (!p.matches(Regex("^\\d{6,10}$"))) return "Digits only (e.g. 12345678)"
        return null
    }
}
