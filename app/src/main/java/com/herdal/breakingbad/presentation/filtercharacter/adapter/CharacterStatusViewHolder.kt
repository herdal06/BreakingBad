package com.herdal.breakingbad.presentation.filtercharacter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.databinding.ItemFilterCharacterBinding

class CharacterStatusViewHolder(
    private val binding: ItemFilterCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: Character) = with(binding) {
        btnFilter.text = character.status
    }
}