package com.example.s4679306assignment2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.s4679306assignment2.ui.login.LoginState
import com.example.s4679306assignment2.ui.login.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun login_success_emitsSuccess() = runTest {
        val repo = FakeRepository()
        val vm = LoginViewModel(repo)
        vm.login("Kailash", "4679306")
        val state = vm.state.value
        assertTrue(state is LoginState.Success)
    }

    @Test
    fun login_blank_showsError() {
        val repo = FakeRepository()
        val vm = LoginViewModel(repo)
        vm.login("", "")
        assertTrue(vm.state.value is LoginState.Error)
    }
}
