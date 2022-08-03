package com.fathan.pokemonapp.data.local

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Type (
    @field:SerializedName("uuid")
    val uuid: String,
    @field:SerializedName("name")
    val name: String
):Parcelable