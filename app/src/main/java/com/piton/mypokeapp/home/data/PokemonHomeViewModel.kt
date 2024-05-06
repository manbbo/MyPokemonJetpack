package com.piton.mypokeapp.home.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piton.mypokeapp.core.data.PokemonClient
import com.piton.mypokeapp.core.model.PokemonShowcaseResponse
import kotlinx.coroutines.launch

class PokemonHomeViewModel : ViewModel() {
    private val service = PokemonClient.api

    val showcasePokemonResponse: MutableLiveData<PokemonShowcaseResponse> =
        MutableLiveData(null)
    val hasError: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getShowcasePokemons() {
        viewModelScope.launch {
            try {
                hasError.postValue(false)

                showcasePokemonResponse.postValue(service.getPokemonList())

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
