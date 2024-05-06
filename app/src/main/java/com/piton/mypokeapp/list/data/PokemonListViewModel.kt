package com.piton.mypokeapp.list.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piton.mypokeapp.core.data.PokemonClient
import com.piton.mypokeapp.core.model.PokemonShowcaseResponse
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {
    private val service = PokemonClient.api

    val pokemonListResponse: MutableLiveData<PokemonShowcaseResponse> =
        MutableLiveData(null)
    val hasError: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getPokemonsByOffset() {
        viewModelScope.launch {
            try {
                hasError.postValue(false)

                pokemonListResponse.postValue(service.getPokemonList(
                    10
                ))

            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    fun getPokemonsByUrl(url: String) {
        viewModelScope.launch {
            try {
                hasError.postValue(false)

                pokemonListResponse.postValue(service.getPokemonListByUrl(
                    url
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
