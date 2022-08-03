package com.fathan.pokemonapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.fathan.pokemonapp.R
import com.fathan.pokemonapp.data.local.Pokemon
import com.fathan.pokemonapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getParcelableExtra<Pokemon>(EXTRA_DATA)
        Log.d("DetailActivity", "onCreate: $data")
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillDataInDetail(data)
    }

    private fun fillDataInDetail(data: Pokemon?) {
        binding.apply {
            idPokemon.setText(data?.number)
            Glide.with(this@DetailActivity)
                .load(data?.avatar)
                .into(imgViewDetail)
            namaPokemon.setText(data?.name)
        }

    }

    companion object{
        const val EXTRA_DATA = "EXTRA_DATA"
    }
}