package edu.ucne.repasoapi.data.repositories

import edu.ucne.repasoapi.data.remote.Verbodto
import edu.ucne.repasoapi.data.remote.VerboApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VerboRepository @Inject constructor(
    private val api: VerboApi
) {

    suspend fun getVerbos(): List<Verbodto> {
        return withContext(Dispatchers.IO) {
            val response = api.getVerbos()
            response.body() ?: emptyList()
        }
    }
}


