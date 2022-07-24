package com.herdal.breakingbad.presentation.filtercharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.herdal.breakingbad.databinding.FragmentFilterCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterCharactersFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFilterCharactersBinding? = null
    private val viewModel: FilterCharactersViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilterCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}