package com.fathan.pokemonapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fathan.pokemonapp.data.local.Pokemon
import com.fathan.pokemonapp.databinding.ItemPokemonBinding

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private val listPokemon = ArrayList<Pokemon>()
    private lateinit var onItemClickCallback : OnItemClickCallback
    class ViewHolder(private val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon){
//            Glide.with(itemView)
//                .load()
            binding.apply {
                tvNamePokemon.text = pokemon.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listPokemon[position])
    }

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    interface OnItemClickCallback{
        fun onItemClicked(data:Pokemon)
    }
}