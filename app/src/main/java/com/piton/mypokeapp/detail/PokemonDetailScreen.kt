package com.piton.mypokeapp.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.piton.mypokeapp.core.composables.ErrorScreen
import com.piton.mypokeapp.core.composables.ImageComposable
import com.piton.mypokeapp.core.composables.LoadingScreen
import com.piton.mypokeapp.detail.composables.PokemonDetailComposable
import com.piton.mypokeapp.detail.data.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(navController: NavHostController, viewModel: PokemonDetailViewModel) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val id = navBackStackEntry?.arguments?.getLong("pokemonId") ?: 0

    viewModel.getPokemonById(id)

    val pokemonDetails =
        viewModel.pokemonResponse.observeAsState(initial = null).value

    val hasError =
        viewModel.hasError.observeAsState(initial = false).value

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (hasError) {
                    ErrorScreen {
                        viewModel.getPokemonById(id)
                    }
                } else {
                    if (pokemonDetails == null) {
                        LoadingScreen()
                    } else {
                        PokemonDetailComposable(pokemonDetail = pokemonDetails)
                    }

                }
            }
        }
    )
}
