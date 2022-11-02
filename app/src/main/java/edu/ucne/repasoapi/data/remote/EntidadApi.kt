package edu.ucne.repasoapi.data.remote

import retrofit2.http.GET

interface EntidadApi {
    @GET("/Entidad")
    suspend fun getEntidad() : List<Entidad>


}