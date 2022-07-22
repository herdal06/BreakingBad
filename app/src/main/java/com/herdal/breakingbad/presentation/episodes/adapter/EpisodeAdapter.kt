package com.herdal.breakingbad.presentation.episodes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.base.BaseListAdapter
import com.herdal.breakingbad.data.remote.model.episode.Episode
import com.herdal.breakingbad.databinding.ItemEpisodeRowBinding

class EpisodeAdapter : BaseListAdapter<Episode>(
    itemsSame = { old, new -> old.episode_id == new.episode_id },
    contentsSame = { old, new -> old == new }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EpisodeViewHolder -> {
                getItem(position)?.let { episode -> holder.bind(episode) }
            }
        }
    }


}