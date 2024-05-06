package com.piton.mypokeapp.core.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.piton.mypokeapp.core.model.PokemonResult

@Composable
fun ItemComposable(
    navHostController: NavHostController,
    pokemonList: List<PokemonResult>,
    scrollState: ScrollState? = null
) {
    val navController = remember { navHostController }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(scrollState ?: rememberScrollState())
    ) {
        repeat(pokemonList.count()) { index ->
            val id = pokemonList[index].getId()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(16.dp))
                    .clickable {
                        navController.navigate(
                            "detailScreen/$id"
                        )
                    }
            ) {
                ImageComposable(
                    200.dp, pokemonList[index].getImageUrl()
                )

                Box(modifier = Modifier
                    .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(16.dp))
                ) {
                    Text(
                        modifier = Modifier
                            .padding(4.dp)
                            .background(Color.White),
                        text = "#$id. ${pokemonList[index].name.uppercase()}"
                    )
                }
            }
        }
    }
}
