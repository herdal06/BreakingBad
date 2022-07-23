package com.herdal.breakingbad.presentation.characters.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.databinding.ItemCharacterRowBinding
import com.herdal.breakingbad.enum.CharacterStatusEnums
import com.herdal.breakingbad.utils.extensions.loadImage

class CharacterViewHolder(
    view: View,
    private val onClickCharacter: ((character: Character) -> Unit)?
) :
    RecyclerView.ViewHolder(view) {
    private val binding = ItemCharacterRowBinding.bind(view)

    fun bind(character: Character) = with(binding) {
        ivCharacter.loadImage(character.img)
        tvCharacterName.text = character.name
        tvCharacterStatus.text = character.status

        when (character.status) {
            CharacterStatusEnums.CHARACTER_ALIVE.value -> tvCharacterStatus.setTextColor(
                Color.parseColor("#00FF00")
            )
            CharacterStatusEnums.CHARACTER_ALIVE.value -> viewStatus.setColorFilter(
                Color.parseColor("#00FF00")
            )
            CharacterStatusEnums.CHARACTER_DECEASED.value -> tvCharacterStatus.setTextColor(
                Color.parseColor("#FF0000")
            )
            CharacterStatusEnums.CHARACTER_DECEASED.value -> viewStatus.setColorFilter(
                Color.parseColor("#FF0000")
            )
            CharacterStatusEnums.CHARACTER_PRESUMED_DEAD.value -> tvCharacterStatus.setTextColor(
                Color.parseColor("#FFA500")
            )
            CharacterStatusEnums.CHARACTER_PRESUMED_DEAD.value -> viewStatus.setColorFilter(
                Color.parseColor("#FFA500")
            )
            else -> {
                tvCharacterStatus.setTextColor(
                    Color.parseColor("#FFFFFF")
                )
                viewStatus.setColorFilter(
                    Color.parseColor("#FFFFFF")
                )
            }
        }
        itemView.setOnClickListener {
            onClickCharacter?.invoke(character)
        }
    }
}