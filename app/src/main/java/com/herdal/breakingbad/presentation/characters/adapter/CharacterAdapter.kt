package com.herdal.breakingbad.presentation.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.R
import com.herdal.breakingbad.base.BaseListAdapter
import com.herdal.breakingbad.data.remote.model.character.Character

class CharacterAdapter(private val onClickCharacter: ((character: Character) -> Unit)?) :
    BaseListAdapter<Character>(
        itemsSame = { old, new -> old.char_id == new.char_id },
        contentsSame = { old, new -> old == new }
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character_row, parent, false)
        return CharacterViewHolder(view, onClickCharacter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> {
                getItem(position)?.let { character -> holder.bind(character) }
            }
        }
    }
}