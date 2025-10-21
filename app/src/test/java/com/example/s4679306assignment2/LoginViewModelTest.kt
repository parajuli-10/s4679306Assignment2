package com.example.s4679306assignment2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.s4679306assignment2.data.Repository
import com.example.s4679306assignment2.ui.login.LoginState
import com.example.s4679306assignment2.ui.login.LoginViewModel
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

/**
 * Unit test for LoginViewModel
 * Author: Kailash Parajuli (s4679306)
 * Campus: Footscray
 */

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    // ✅ Fake Repository for testing (no network calls)
    class FakeRepository : Repository(mockk(relaxed = true)) {
        override suspend fun login(username: String, password: String): String {
            return if (username.equals("Kailash", true) && password == "4679306") {
                "investments"
            } else {
                throw Exception("Invalid credentials")
            }
        }
    }

    @Test
    fun login_success_emitsSuccess() = runTest {
        val vm = LoginViewModel(FakeRepository())
        vm.login("Kailash", "4679306")
        val state = vm.state.value
        assertTrue(state is LoginState.Success)
    }

    @Test
    fun login_blank_emitsError() {
        val vm = LoginViewModel(FakeRepository())
        vm.login("", "")
        assertTrue(vm.state.value is LoginState.Error)
    }

    @Test
    fun login_wrongCredentials_emitsError() = runTest {
        val vm = LoginViewModel(FakeRepository())
        vm.login("Kailash", "wrongpass")
        val state = vm.state.value
        assertTrue(state is LoginState.Error)
    }
}
