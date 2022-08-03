package com.fathan.pokemonapp.data.remote

import com.fathan.pokemonapp.data.local.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("pokemons")
    fun getDataPokemons(@Query("limit") limit: Int, @Query("page") page: Int):Call<PokemonResponse>
}