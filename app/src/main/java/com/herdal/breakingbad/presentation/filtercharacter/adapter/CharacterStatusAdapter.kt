package com.herdal.breakingbad.presentation.filtercharacter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.base.BaseListAdapter
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.databinding.ItemFilterCharacterBinding


class CharacterStatusAdapter() :
    BaseListAdapter<Character>(
        itemsSame = { old, new -> old.char_id == new.char_id },
        contentsSame = { old, new -> old == new }
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return CharacterStatusViewHolder(
            ItemFilterCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterStatusViewHolder -> {
                getItem(position)?.let { character -> holder.bind(character) }
            }
        }
    }
}
