package com.herdal.breakingbad.presentation.characters

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.herdal.breakingbad.R
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.databinding.FragmentCharactersBinding
import com.herdal.breakingbad.presentation.characters.adapter.CharacterAdapter
import com.herdal.breakingbad.presentation.characters.adapter.CharacterItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val viewModel: CharactersViewModel by viewModels()
    private val characterAdapter: CharacterAdapter by lazy {
        CharacterAdapter(::onClickCharacter)
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
        addMenuProvider()
    }

    private fun addMenuProvider() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.search_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.search_action -> {
                        // searchCharacters()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setupRecyclerView() = with(binding) {
        recyclerViewCharacters.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = characterAdapter
            this.addItemDecoration(CharacterItemDecorator(requireContext()))
        }
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_charactersFragment_to_filterCharactersFragment)
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

    private fun onClickCharacter(character: Character) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                character
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}