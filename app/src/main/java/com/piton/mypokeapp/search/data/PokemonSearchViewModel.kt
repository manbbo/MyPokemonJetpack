package com.piton.mypokeapp.search.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piton.mypokeapp.core.data.PokemonClient
import com.piton.mypokeapp.core.model.PokemonResponse
import kotlinx.coroutines.launch

class PokemonSearchViewModel : ViewModel() {
    private val service = PokemonClient.api

    val pokemonResponse: MutableLiveData<PokemonResponse> =
        MutableLiveData(null)
    val searchInput: MutableLiveData<String> =
        MutableLiveData(null)

    val hasError: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getPokemonByName(name: String) {
        searchInput.postValue(name)

        viewModelScope.launch {
            try {
                hasError.postValue(false)

                pokemonResponse.postValue(service.getPokemonByName(
                    name
                ))

            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    fun getPokemonById(id: Long) {
        searchInput.postValue(id.toString())

        viewModelScope.launch {
            try {
                hasError.postValue(false)

                pokemonResponse.postValue(service.getPokemonById(
                    id
                ))

            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    private fun handleException(exception: Exception) {
        hasError.postValue(true)
        Log.e(this.javaClass.name, "Error occurred: ${exception.message}", exception)
    }
}

