package com.piton.mypokeapp.detail.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piton.mypokeapp.core.data.PokemonClient
import com.piton.mypokeapp.core.model.PokemonResponse
import kotlinx.coroutines.launch

class PokemonDetailViewModel : ViewModel() {
    private val service = PokemonClient.api

    val pokemonResponse: MutableLiveData<PokemonResponse> =
        MutableLiveData(null)
    val hasError: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getPokemonById(id: Long) {
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
