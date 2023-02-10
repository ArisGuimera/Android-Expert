package com.aristidevs.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperheroItemResponse) {
        binding.tvSuperheroName.text = superheroItemResponse.name
    }
}