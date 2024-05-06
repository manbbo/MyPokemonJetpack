package com.piton.mypokeapp.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.piton.mypokeapp.core.composables.ErrorScreen
import com.piton.mypokeapp.core.composables.LoadingScreen
import com.piton.mypokeapp.detail.composables.PokemonDetailComposable
import com.piton.mypokeapp.search.composable.SearchBarComposite
import com.piton.mypokeapp.search.data.PokemonSearchViewModel

@Composable
fun PokemonSearchScreen(navController: NavHostController, viewModel: PokemonSearchViewModel) {
    val pokemonSearch =
        viewModel.pokemonResponse.observeAsState(initial = null).value

    val searchInput =
        viewModel.searchInput.observeAsState(initial = null).value

    val hasError =
        viewModel.hasError.observeAsState(initial = false).value

    Scaffold(
        topBar = {
            SearchBarComposite(navController, viewModel)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (hasError) {
                ErrorScreen {
                    if (searchInput?.trim()?.toLongOrNull() != null) {
                        viewModel.getPokemonById(searchInput.toLong())
                    } else {
                        viewModel.getPokemonByName(searchInput?.lowercase() ?: "")
                    }
                }
            } else {
                if (searchInput?.isNotEmpty() == true) {
                    if (pokemonSearch == null) {
                        LoadingScreen()
                    } else {
                            PokemonDetailComposable(pokemonDetail = pokemonSearch)
                    }
                }
            }
        }
    }
}

