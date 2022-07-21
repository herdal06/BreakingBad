package com.herdal.breakingbad.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.herdal.breakingbad.databinding.FragmentCharactersBinding
import com.herdal.breakingbad.presentation.characters.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val viewModel: CharactersViewModel by viewModels()
    private val characterAdapter: CharacterAdapter by lazy {
        CharacterAdapter()
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeLiveData()
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerViewCharacters.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = characterAdapter
        }
    }

    private fun observeLiveData() {

        viewModel.characters.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getAllCharacters()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}