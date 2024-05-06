package com.piton.mypokeapp.detail.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piton.mypokeapp.core.composables.ImageComposable
import com.piton.mypokeapp.core.model.PokemonResponse

@Composable
fun PokemonDetailComposable(pokemonDetail: PokemonResponse) {
    Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column {

            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(16.dp))
                    .height(350.dp)
            ) {
                Column {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .border(
                                BorderStroke(1.dp, Color.Black),
                                RoundedCornerShape(16.dp)
                            )
                            .height(290.dp)
                    ) {
                        ImageComposable(Dp.Infinity, pokemonDetail.sprites.frontDefault.orEmpty())
                    }

                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "#${pokemonDetail.id} ${pokemonDetail.name.uppercase()}",
                                fontSize = 22.sp
                            )
                            Text(text = "Height: ${pokemonDetail.height} Weight: ${pokemonDetail.weight}")
                        }
                    }
                }
            }

            // TODO: Add other attributes

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(8.dp)
                    .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(16.dp))
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Moves:", fontSize = 20.sp)

                    Spacer(modifier = Modifier.height(4.dp))

                    repeat(pokemonDetail.moves.count()) { index ->
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp), text = pokemonDetail.moves[index].move.name
                        )
                    }
                }
            }
        }
    }
}
