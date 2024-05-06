package com.piton.mypokeapp.core.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonClient {
    private const val BASE_URL = "https://pokeapi.co/"

    val api: PokemonApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PokemonApi::class.java)
    }
}
