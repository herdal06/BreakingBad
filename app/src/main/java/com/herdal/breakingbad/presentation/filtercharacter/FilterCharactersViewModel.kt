package com.herdal.breakingbad.presentation.filtercharacter

import androidx.lifecycle.ViewModel
import com.herdal.breakingbad.data.remote.characters.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterCharactersViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel() {
}