package com.herdal.breakingbad.presentation.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.herdal.breakingbad.R
import com.herdal.breakingbad.databinding.FragmentEpisodesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment : Fragment() {

    private var _binding: FragmentEpisodesBinding? = null
    private val viewModel: EpisodesViewModel by viewModels()

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
        binding.apply {
            button2.setOnClickListener {
                findNavController().navigate(R.id.action_episodesFragment_to_episodeDetailsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}