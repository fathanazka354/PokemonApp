package com.fathan.pokemonapp.data.local

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("data")
    val data: List<Pokemon>
)