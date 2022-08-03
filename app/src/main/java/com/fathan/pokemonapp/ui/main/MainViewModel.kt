package com.fathan.pokemonapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fathan.pokemonapp.data.local.Pokemon
import com.fathan.pokemonapp.data.local.PokemonResponse
import com.fathan.pokemonapp.data.remote.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    val listPokemon = MutableLiveData<List<Pokemon>>()

    fun getPokemon(){
        val pokemonList = ArrayList<Pokemon>()
        val client = ApiConfig.getApiService().getDataPokemons(limit = 10, page = 1)

        _isLoading.value = true
        client.enqueue(object : Callback<PokemonResponse>{
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    Log.d("MainViewModel", "onResponse: $responseBody")
                    _isLoading.value = false
                    listPokemon.postValue(responseBody?.data)
                    listPokemon.value = pokemonList
                }else{
                    _isLoading.value = false
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.d("MainViewModel", "onFailure: ${t.message}")
                _isLoading.value = false
            }
        })
    }
}