package com.fathan.pokemonapp.data.local

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon (
    @field:SerializedName("uuid")
    val uuid: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("number")
    val number: String,
    @field:SerializedName("types")
    val types: List<Type>,
    @field:SerializedName("avatar")
    val avatar: String,
): Parcelable