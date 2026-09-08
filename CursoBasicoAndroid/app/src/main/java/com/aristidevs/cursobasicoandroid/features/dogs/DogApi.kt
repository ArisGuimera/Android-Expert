package com.aristidevs.cursobasicoandroid.features.dogs

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET

//https://raw.githubusercontent.com/ArisGuimera/Android-Expert/temp/api/dog/dogs.json

const val BASE_URL = "https://raw.githubusercontent.com/ArisGuimera/Android-Expert/temp/api/dog/"

interface DogApiService {

    @GET("dogs.json")
    suspend fun getDogs(): List<Dog>

}

object DogApi {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    val services: DogApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                )
            ).build()
        .create(DogApiService::class.java)
}







