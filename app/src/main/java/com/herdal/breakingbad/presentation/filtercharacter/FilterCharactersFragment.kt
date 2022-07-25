package com.herdal.breakingbad.presentation.filtercharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.herdal.breakingbad.R
import com.herdal.breakingbad.databinding.FragmentFilterCharactersBinding
import com.herdal.breakingbad.presentation.characters.adapter.CharacterItemDecorator
import com.herdal.breakingbad.presentation.filtercharacter.adapter.FilterCharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterCharactersFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFilterCharactersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: FilterCharactersViewModel by viewModels()
    private val characterStatusAdapter: FilterCharacterAdapter by lazy {
        FilterCharacterAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilterCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerViewCharacterStatus.apply {
            setHasFixedSize(true)
            adapter = characterStatusAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}