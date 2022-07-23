package com.herdal.breakingbad.presentation.episodedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.herdal.breakingbad.databinding.FragmentEpisodeDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailsFragment : Fragment() {

    private var _binding: FragmentEpisodeDetailsBinding? = null
    private val viewModel: EpisodeDetailsViewModel by viewModels()
    private val args: EpisodeDetailsFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun getArgs() = args.episode

    private fun initViews() = with(binding) {
        val episode = getArgs()
        tvEpisodeName.text = episode.title
        tvSeason.text = episode.season
        tvDetailsEpisode.text = episode.episode
        tvAirDate.text = episode.air_date
        tvCharacters.text = episode.characters.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}