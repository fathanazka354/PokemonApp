package com.fathan.pokemonapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fathan.pokemonapp.R
import com.fathan.pokemonapp.data.local.Pokemon
import com.fathan.pokemonapp.databinding.ActivityMainBinding
import com.fathan.pokemonapp.ui.detail.DetailActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this,ViewModelFactory())[MainViewModel::class.java]


        mainViewModel.getPokemon()
        mainViewModel.listPokemon.observe(this){
            setAdapter(it)
            Log.d("MainActivity", "onCreate: $it")
        }


        mainViewModel.isLoading.observe(this,{
            showLoading(it)
        })
        actionBar?.setIcon(R.drawable.pokemon_logo)

    }

    private fun setAdapter(data: List<Pokemon>) {
        binding.apply {
            val adapter = PokemonAdapter(data)
            rvPokemon.layoutManager = GridLayoutManager(this@MainActivity,2)
            rvPokemon.adapter = adapter
            adapter.setOnClickCallback(object : PokemonAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Pokemon) {
                    Intent(this@MainActivity,DetailActivity::class.java).let {
                        it.putExtra(DetailActivity.EXTRA_DATA,data)
                        startActivity(it)
                    }
                }
            })
        }
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