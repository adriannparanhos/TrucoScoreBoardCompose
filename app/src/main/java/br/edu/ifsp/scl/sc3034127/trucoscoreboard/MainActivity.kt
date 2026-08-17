package br.edu.ifsp.scl.sc3034127.trucoscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3034127.trucoscoreboard.ui.theme.TrucoScoreBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TrucoScoreBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TrucoScreenAula2(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TrucoScreenAula2(modifier: Modifier = Modifier) {

    var scoreA by remember { mutableIntStateOf(0) }
    var scoreB by remember { mutableIntStateOf(0) }

    var winner = ""
    if (scoreA >= 12) winner = "Equipe A Venceu!"
    if (scoreB >= 12) winner = "Equipe B Venceu!"

    var maoDe11 = ""
    if (scoreA == 11 && scoreB == 11) maoDe11 = "Mão de 11 para ambas as equipes!"
    else if (scoreA == 11) maoDe11 = "Atenção: Mão de 11 - Equipe A!"
    else if (scoreB == 11) maoDe11 = "Atenção: Mão de 11 - Equipe B!"

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = winner, fontSize = 28.sp, color = Color.Green)
        Text(text = maoDe11, fontSize = 20.sp, color = Color.Red)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Equipe A", fontSize = 24.sp)
                Text(text = scoreA.toString(), fontSize = 64.sp)

                Button(onClick = {
                    if (winner.isEmpty()) scoreA = (scoreA + 1).coerceAtMost(12)
                }) {
                    Text("+ 1 Ponto")
                }

                Button(onClick = {
                    if (winner.isEmpty()) scoreA = (scoreA + 3).coerceAtMost(12)
                }) {
                    Text("+ 3 Pontos")
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Equipe B", fontSize = 24.sp)
                Text(text = scoreB.toString(), fontSize = 64.sp)

                Button(onClick = {
                    if (winner.isEmpty()) scoreB = (scoreB + 1).coerceAtMost(12)
                }) {
                    Text("+ 1 Ponto")
                }

                Button(onClick = {
                    if (winner.isEmpty()) scoreB = (scoreB + 3).coerceAtMost(12)
                }) {
                    Text("+ 3 Pontos")
                }
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(onClick = {
            scoreA = 0
            scoreB = 0
        }) {
            Text("Reiniciar Partida")
        }
    }
}