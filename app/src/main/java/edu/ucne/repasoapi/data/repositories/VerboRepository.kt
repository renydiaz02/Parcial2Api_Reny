package edu.ucne.repasoapi.data.repositories

import androidx.compose.ui.semantics.SemanticsProperties.Error
import coil.network.HttpException
import edu.ucne.repasoapi.data.remote.Verbo
import edu.ucne.repasoapi.data.remote.VerboApi
import edu.ucne.repasoapi.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class VerboRepository @Inject constructor(
    private val api: VerboApi
) {
    fun getVerbos(): Flow<Resource<List<Verbo>>> = flow {
        try {
            emit(Resource.Loading())
            val verbo= api.getVerbos()
            emit(Resource.Success(verbo))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar conexión a internet"))
        }
    }
}

