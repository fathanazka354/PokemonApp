package com.fathan.pokemonapp.data.local

import retrofit2.http.Field

data class Pokemon (
    @Field("uuid")
    val uuid: String,
    @Field("name")
    val name: String,
    @Field("number")
    val number: String,
    @Field("types")
    val types: String,
)