package com.fathan.pokemonapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fathan.pokemonapp.data.local.Pokemon
import com.fathan.pokemonapp.databinding.ItemPokemonBinding

class PokemonAdapter(val listPokemon : List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback
    inner class ViewHolder(private val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon){
            binding.apply {
                tvNamePokemon.text = pokemon.name
                Glide.with(itemView)
                    .load(pokemon.avatar)
                    .into(imgPokemon)

                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(data = pokemon)
                }
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
        return listPokemon.size
    }


    interface OnItemClickCallback{
        fun onItemClicked(data:Pokemon)
    }
}