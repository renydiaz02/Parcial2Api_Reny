package edu.ucne.repasoapi.data.remote

data class EntidadListState (
    val isLoading : Boolean = false,
    val entidad : List<Entidad> = emptyList(),
    val error : String = ""
    )