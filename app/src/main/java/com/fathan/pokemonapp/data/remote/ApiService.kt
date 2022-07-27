package com.fathan.pokemonapp.data.remote

import com.fathan.pokemonapp.data.local.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("pokemons?limit=10&page=1")
    fun getDataPokemons():Call<PokemonResponse>
}