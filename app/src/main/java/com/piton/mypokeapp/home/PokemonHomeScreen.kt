package com.piton.mypokeapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.piton.mypokeapp.core.composables.ErrorScreen
import com.piton.mypokeapp.core.composables.ItemComposable
import com.piton.mypokeapp.core.composables.LoadingScreen
import com.piton.mypokeapp.home.data.PokemonHomeViewModel

@Composable
fun PokemonHomeScreen(navController: NavHostController, viewModel: PokemonHomeViewModel) {
    val initialPokemonShowcaseResponse =
        viewModel.showcasePokemonResponse.observeAsState(initial = null).value

    val hasError =
        viewModel.hasError.observeAsState(initial = false).value

    val onButtonClick: () -> Unit = {
        navController.navigate("listScreen")
    }

    if (hasError) {
        ErrorScreen {
            viewModel.getShowcasePokemons()
        }
    } else {
        if (initialPokemonShowcaseResponse == null) {
            LoadingScreen()
        } else {
            Scaffold(
                topBar = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { navController.navigate("searchScreen") }) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }

                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(
                                onClick = onButtonClick,
                            ) {
                                Text("See full list")
                            }
                        }
                    }
                },
                content = { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        initialPokemonShowcaseResponse?.let {
                            ItemComposable(
                                navHostController = navController,
                                pokemonList = initialPokemonShowcaseResponse.results
                            )

                        }
                    }
                }
            )
        }
    }
}
