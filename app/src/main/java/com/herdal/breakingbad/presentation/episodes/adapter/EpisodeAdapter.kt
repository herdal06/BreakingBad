package com.herdal.breakingbad.presentation.episodes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.R
import com.herdal.breakingbad.base.BaseListAdapter
import com.herdal.breakingbad.data.remote.model.episode.Episode

class EpisodeAdapter(private val onClickEpisode: ((episode: Episode) -> Unit)?) :
    BaseListAdapter<Episode>(
        itemsSame = { old, new -> old.episode_id == new.episode_id },
        contentsSame = { old, new -> old == new }
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_episode_row, parent, false)
        return EpisodeViewHolder(view, onClickEpisode)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EpisodeViewHolder -> {
                getItem(position)?.let { episode -> holder.bind(episode) }
            }
        }
    }
}