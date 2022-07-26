package com.herdal.breakingbad.presentation.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.data.remote.model.episode.Episode
import com.herdal.breakingbad.databinding.FragmentEpisodesBinding
import com.herdal.breakingbad.presentation.characters.CharactersFragmentDirections
import com.herdal.breakingbad.presentation.episodes.adapter.EpisodeAdapter
import com.herdal.breakingbad.presentation.episodes.adapter.EpisodeItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment : Fragment() {

    private var _binding: FragmentEpisodesBinding? = null
    private val viewModel: EpisodesViewModel by viewModels()
    private val episodeAdapter: EpisodeAdapter by lazy {
        EpisodeAdapter(::onClickEpisode)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.episodes.observe(viewLifecycleOwner) {
            episodeAdapter.submitList(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getAllEpisodes()
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerViewEpisodes.apply {
            setHasFixedSize(true)
            adapter = episodeAdapter
            this.addItemDecoration(EpisodeItemDecorator(context))
            this.addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun onClickEpisode(episode: Episode) {
        findNavController().navigate(
            EpisodesFragmentDirections.actionEpisodesFragmentToEpisodeDetailsFragment(
                episode
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}