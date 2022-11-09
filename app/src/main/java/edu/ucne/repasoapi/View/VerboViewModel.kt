package edu.ucne.repasoapi.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.repasoapi.data.remote.Verbodto
import edu.ucne.repasoapi.data.repositories.VerboRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

data class VerbosListUiState(
    val verbos : List<Verbodto> = emptyList()
)

@HiltViewModel

class VerboViewModel @Inject constructor(

    private val verboRepository: VerboRepository
) : ViewModel() {
    private val _state = MutableStateFlow(VerbosListUiState())
    val state: StateFlow<VerbosListUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.getAndUpdate {
                try {
                    it.copy(verbos = verboRepository.getVerbos())
                } catch (ioe: IOException) {
                    it.copy(verbos = emptyList())
                }
            }
        }
    }
}