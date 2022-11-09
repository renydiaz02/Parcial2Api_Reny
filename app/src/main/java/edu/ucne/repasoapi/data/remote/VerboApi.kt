package edu.ucne.repasoapi.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface VerboApi {
    @GET("/verbos")
    suspend fun getVerbos() : Response <List<Verbodto>>

}