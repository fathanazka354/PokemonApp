package com.fathan.pokemonapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.fathan.pokemonapp.R
import com.fathan.pokemonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this,ViewModelFactory())[MainViewModel::class.java]


        mainViewModel.getPokemon()
        mainViewModel.isLoading.observe(this,{
            showLoading(it)
        })
        actionBar?.setIcon(R.drawable.pokemon_logo)

    }
    private fun showLoading(state: Boolean){
        if (state){
            binding.pgBar.visibility = View.VISIBLE
            binding.rvPokemon.visibility = View.GONE
        }else{
            binding.pgBar.visibility = View.GONE
            binding.rvPokemon.visibility = View.VISIBLE
        }
    }
}