package com.herdal.breakingbad.presentation.filtercharacter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herdal.breakingbad.data.remote.characters.CharactersRepository
import com.herdal.breakingbad.data.remote.model.character.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class FilterCharactersViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel() {

    val characters = MutableLiveData<List<Character>>()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}