package com.piton.mypokeapp.search.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavHostController
import com.piton.mypokeapp.search.data.PokemonSearchViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchBarComposite(navController: NavHostController, viewModel: PokemonSearchViewModel) {
    var searchPokemon by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    var job: Job? by remember { mutableStateOf(null) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Row {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
        }
        Box (modifier = Modifier.fillMaxWidth()) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = true,
                value = searchPokemon,
                onValueChange = { input ->
                    searchPokemon = input.lowercase()
                    job?.cancel()
                    job = scope.launch {
                        delay(2000)

                        if (input.trim().toLongOrNull() != null) {
                            viewModel.getPokemonById(input.toLong())
                        } else {
                            viewModel.getPokemonByName(input.lowercase())
                        }

                        keyboardController?.hide()
                    }
                },
                maxLines = 1,
                placeholder = {
                    Text(text = "Search for a pokemon")
                }
            )
        }
    }
}