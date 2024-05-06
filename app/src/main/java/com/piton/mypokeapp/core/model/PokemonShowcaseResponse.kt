package com.piton.mypokeapp.core.model

import com.google.gson.annotations.SerializedName

data class PokemonShowcaseResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PokemonResult>
)

data class PokemonResult(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun getImageUrl(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getId()}.png"

    fun getId(): Long {
        var getStrings = url.split("/")
            .toMutableList()

        getStrings.removeIf { it.isNullOrBlank() || it.isNullOrEmpty() }

        return getStrings.last().toLong()
    }
}

