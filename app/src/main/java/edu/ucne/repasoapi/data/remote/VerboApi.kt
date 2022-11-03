package edu.ucne.repasoapi.data.remote

import retrofit2.http.GET

interface VerboApi {
    @GET("/verbos")
    suspend fun getVerbos() : List<Verbo>


}