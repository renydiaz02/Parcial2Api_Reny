package edu.ucne.repasoapi.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.repasoapi.data.remote.EntidadApi
import edu.ucne.repasoapi.data.repositories.EntidadRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideEntidadApi(moshi: Moshi) : EntidadApi {
        return Retrofit.Builder()
            .baseUrl("AQUI VA EL ENLACE DE LA API")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(EntidadApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEntidadRepository(api: EntidadApi) : EntidadRepository {
        return EntidadRepository()//api)
    }
}