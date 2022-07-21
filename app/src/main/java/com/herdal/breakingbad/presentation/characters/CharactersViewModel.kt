package com.herdal.breakingbad.presentation.characters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.breakingbad.data.remote.characters.CharactersRepository
import com.herdal.breakingbad.data.remote.model.character.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel() {

    val characters = MutableLiveData<List<Character>>()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getAllCharacters() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getAllCharacters()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    characters.postValue(response.body())
                } else {
                    Log.e("CharactersViewModel", "getAllMovies: ${response.code()}")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}