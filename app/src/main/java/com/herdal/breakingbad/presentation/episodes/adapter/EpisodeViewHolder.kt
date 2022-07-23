package com.herdal.breakingbad.presentation.episodes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.data.remote.model.episode.Episode
import com.herdal.breakingbad.databinding.ItemEpisodeRowBinding

class EpisodeViewHolder(
    view: View,
    private val onClickEpisode: ((episode: Episode) -> Unit)?
) :
    RecyclerView.ViewHolder(view) {
    private val binding = ItemEpisodeRowBinding.bind(view)

    fun bind(episode: Episode) = with(binding) {
        tvEpisode.text = episode.season + "x" + episode.episode
        tvEpisodeTitle.text = episode.title
        itemView.setOnClickListener {
            onClickEpisode?.invoke(episode)
        }
    }
}