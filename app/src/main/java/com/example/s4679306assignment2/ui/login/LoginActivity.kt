package com.example.s4679306assignment2.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.s4679306assignment2.databinding.ActivityLoginBinding
import com.example.s4679306assignment2.ui.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start with button disabled until inputs are valid
        binding.btnLogin.isEnabled = false

        // Live validation hooks
        binding.etUsername.doAfterTextChanged { vm.onUsernameChanged(it?.toString().orEmpty()) }
        binding.etPassword.doAfterTextChanged { vm.onPasswordChanged(it?.toString().orEmpty()) }

        binding.etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE && binding.btnLogin.isEnabled) {
                binding.btnLogin.performClick()
                true
            } else false
        }

        binding.btnLogin.setOnClickListener {
            binding.tvError.isVisible = false
            hideKeyboard(binding.root)
            vm.login(
                usernameRaw = binding.etUsername.text.toString(),
                passwordRaw = binding.etPassword.text.toString()
            )
        }

        // Field error observers
        vm.usernameError.observe(this) { err ->
            binding.tilUsername.error = err
            updateButtonEnabled()
        }
        vm.passwordError.observe(this) { err ->
            binding.tilPassword.error = err
            updateButtonEnabled()
        }

        // State observer
        vm.state.observe(this) { state ->
            when (state) {
                LoginState.Idle -> setLoading(false, showError = false, errorText = null)
                LoginState.Loading -> setLoading(true, showError = false, errorText = null)
                is LoginState.Error -> setLoading(false, showError = true, errorText = state.message)
                is LoginState.Success -> {
                    setLoading(false, showError = false, errorText = null)
                    startActivity(Intent(this, DashboardActivity::class.java).apply {
                        putExtra(DashboardActivity.EXTRA_KEYPASS, state.keypass)
                    })
                    finish()
                }
            }
        }
    }

    private fun setLoading(loading: Boolean, showError: Boolean, errorText: String?) {
        binding.loadingOverlay.isVisible = loading
        binding.tvError.isVisible = showError
        binding.tvError.text = errorText ?: ""
        // Lock inputs while loading to prevent double submit
        binding.etUsername.isEnabled = !loading
        binding.etPassword.isEnabled = !loading
        binding.btnLogin.isEnabled = !loading && currentFieldsValid()
    }

    private fun updateButtonEnabled() {
        binding.btnLogin.isEnabled = currentFieldsValid()
    }

    private fun currentFieldsValid(): Boolean =
        binding.tilUsername.error.isNullOrBlank() &&
                binding.tilPassword.error.isNullOrBlank() &&
                binding.etUsername.text?.isNotBlank() == true &&
                binding.etPassword.text?.isNotBlank() == true

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
