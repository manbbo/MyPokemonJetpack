package com.piton.mypokeapp.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.piton.mypokeapp.core.composables.ErrorScreen
import com.piton.mypokeapp.core.composables.ItemComposable
import com.piton.mypokeapp.core.composables.LoadingScreen
import com.piton.mypokeapp.list.data.PokemonListViewModel

@Composable
fun PokemonListScreen(navController: NavHostController, viewModel: PokemonListViewModel) {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        viewModel.getPokemonsByOffset()
    }

    val pokemonListResponse =
        viewModel.pokemonListResponse.observeAsState(initial = null).value

    val hasError =
        viewModel.hasError.observeAsState(initial = false).value

    val onPreviousClicked: () -> Unit = {
        pokemonListResponse?.let { pokemon ->
            pokemon.previous?.let {
                viewModel.getPokemonsByUrl(it)
            }
        }
    }

    val onNextClicked: () -> Unit = {
        pokemonListResponse?.let { pokemon ->
            pokemon.next?.let {
                viewModel.getPokemonsByUrl(it)
            }
        }
    }

    Scaffold(
        topBar = {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = onPreviousClicked,
                        enabled = pokemonListResponse?.previous != null,
                        modifier = Modifier.padding(horizontal = 4.dp),
                    ) {
                        Text("Previous")
                    }
                    Button(
                        onClick = onNextClicked,
                        enabled = pokemonListResponse?.next != null,
                        modifier = Modifier.padding(horizontal = 4.dp),
                    ) {
                        Text("Next")
                    }
                }
            }
        },
        content = { innerPadding ->
            LaunchedEffect(pokemonListResponse) {
                scrollState.scrollTo(0)
            }

            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (hasError) {
                    ErrorScreen {
                        viewModel.getPokemonsByOffset()
                    }
                } else {
                    if (pokemonListResponse == null) {
                        LoadingScreen()
                    } else {
                        ItemComposable(
                            navHostController = navController,
                            pokemonList = pokemonListResponse.results,
                            scrollState = scrollState
                        )
                    }
                }
            }
        }
    )
}