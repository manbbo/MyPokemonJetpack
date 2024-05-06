package com.piton.mypokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.piton.mypokeapp.detail.PokemonDetailScreen
import com.piton.mypokeapp.detail.data.PokemonDetailViewModel
import com.piton.mypokeapp.home.PokemonHomeScreen
import com.piton.mypokeapp.home.data.PokemonHomeViewModel
import com.piton.mypokeapp.list.PokemonListScreen
import com.piton.mypokeapp.list.data.PokemonListViewModel
import com.piton.mypokeapp.search.PokemonSearchScreen
import com.piton.mypokeapp.search.data.PokemonSearchViewModel
import com.piton.mypokeapp.ui.theme.MyPokeAppTheme

class MainActivity : ComponentActivity() {
    private val homeViewModel: PokemonHomeViewModel by viewModels()
    private val listViewModel: PokemonListViewModel by viewModels()
    private val detailViewModel: PokemonDetailViewModel by viewModels()
    private val searchViewModel: PokemonSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            homeViewModel.getShowcasePokemons()

            MyPokeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "homeScreen") {
                        composable("homeScreen"){
                            PokemonHomeScreen(navController = navController, viewModel = homeViewModel)
                        }
                        composable("detailScreen/{pokemonId}", arguments = listOf(
                            navArgument("pokemonId") {
                                type = NavType.LongType
                            }
                        )) {
                            PokemonDetailScreen(navController = navController, viewModel = detailViewModel)
                        }
                        composable("listScreen"){
                            PokemonListScreen(navController = navController, viewModel = listViewModel)
                        }
                        composable("searchScreen"){
                            PokemonSearchScreen(navController = navController, viewModel = searchViewModel)
                        }
                    }

                }
            }
        }
    }
}
