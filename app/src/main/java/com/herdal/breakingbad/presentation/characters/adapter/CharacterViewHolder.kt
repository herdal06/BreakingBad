package com.herdal.breakingbad.presentation.characters.adapter

import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.databinding.ItemCharacterRowBinding
import com.herdal.breakingbad.utils.extensions.loadImage

class CharacterViewHolder(private val binding: ItemCharacterRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(character: Character) = with(binding) {
        ivCharacter.loadImage(character.img)
        tvCharacterName.text = character.name
    }
}