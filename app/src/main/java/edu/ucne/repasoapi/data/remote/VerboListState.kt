package edu.ucne.repasoapi.data.remote

data class VerboListState (
    val isLoading: Boolean = false,
    val verbos: List<Verbo> = emptyList(),
    val error: String = ""
    )