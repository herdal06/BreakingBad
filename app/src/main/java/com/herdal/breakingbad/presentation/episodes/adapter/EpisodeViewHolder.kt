package com.herdal.breakingbad.presentation.episodes.adapter

import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.data.remote.model.episode.Episode
import com.herdal.breakingbad.databinding.ItemEpisodeRowBinding

class EpisodeViewHolder(private val binding: ItemEpisodeRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(episode: Episode) = with(binding) {
        tvEpisode.text = episode.season + "x" + episode.episode
        tvEpisodeTitle.text = episode.title
    }
}