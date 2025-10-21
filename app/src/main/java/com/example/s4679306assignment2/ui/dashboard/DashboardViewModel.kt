package com.example.s4679306assignment2.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s4679306assignment2.data.Repository
import com.example.s4679306assignment2.data.remote.DashboardEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

data class DashboardUiState(
    val loading: Boolean = false,
    val entities: List<DashboardEntity> = emptyList(),
    val total: Int = 0,
    val error: String? = null
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repo: Repository
) : ViewModel() {

    private val _state = MutableLiveData(DashboardUiState())
    val state: LiveData<DashboardUiState> = _state

    fun load(keypass: String) {
        if (keypass.isBlank()) {
            _state.value = DashboardUiState(error = "Missing keypass from login.")
            return
        }

        // avoid double-load
        if (_state.value?.loading == true) return

        _state.value = _state.value?.copy(loading = true, error = null)
        viewModelScope.launch {
            try {
                val res = repo.dashboard(keypass)
                _state.value = DashboardUiState(
                    loading = false,
                    entities = res.entities,
                    total = res.entityTotal,
                    error = null
                )
            } catch (e: HttpException) {
                _state.value = DashboardUiState(
                    loading = false,
                    error = "Server error (${e.code()}). Please try again."
                )
            } catch (_: IOException) {
                _state.value = DashboardUiState(
                    loading = false,
                    error = "Network error. Pull to refresh."
                )
            } catch (e: Exception) {
                _state.value = DashboardUiState(
                    loading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }
}
