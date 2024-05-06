package com.piton.mypokeapp.core.data

import com.piton.mypokeapp.core.model.PokemonResponse
import com.piton.mypokeapp.core.model.PokemonShowcaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApi {
    @GET("/api/v2/pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Long = 5
    ): PokemonShowcaseResponse

    @GET
    suspend fun getPokemonListByUrl(
        @Url url: String
    ): PokemonShowcaseResponse

    @GET("/api/v2/pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String
    ): PokemonResponse

    @GET("/api/v2/pokemon/{pokemonId}")
    suspend fun getPokemonById(
        @Path("pokemonId") pokemonId: Long
    ): PokemonResponse

}