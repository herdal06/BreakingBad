package com.herdal.breakingbad.presentation.episodes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.herdal.breakingbad.data.remote.characters.CharactersRepository
import com.herdal.breakingbad.data.remote.model.episode.Episode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel() {
    val episodes = MutableLiveData<List<Episode>>()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getAllEpisodes() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getAllEpisodes()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    episodes.postValue(response.body())
                } else {
                    Log.e("EpisodesViewModel", "getAllEpisodes: ${response.code()}")
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