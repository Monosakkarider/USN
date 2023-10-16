package com.example.romana3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.romana3.ui.theme.RomanA3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            RomanA3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController) }
                        composable("destination1") { Greeting("Norway", "Oslo", "5.3 mill", "nok") }
                        composable("destination2") { Greeting("Sweden", "Stockholm", "10.2 mill", "sek") }
                        composable("destination3") { Greeting("Denmark", "Copenhagen", "5.7 mill", "dkk") }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        NorButton(navController = navController)
        SweButton(navController = navController)
        DenButton(navController = navController)
    }
}

@Composable
fun Greeting(name: String, cap: String, pop: String, cur: String) {
    Text(
        text = "Country $name!",
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = "Capital $cap!",
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = "Population $pop!",
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = "Currency $cur!",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun NorButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("destination1") },
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "Norway")

    }
}

@Composable
fun SweButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("destination2") },
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "Sweden")
    }
}

@Composable
fun DenButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("destination3") },
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "Denmark")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RomanA3Theme {
        HomeScreen(navController = rememberNavController())
    }
}