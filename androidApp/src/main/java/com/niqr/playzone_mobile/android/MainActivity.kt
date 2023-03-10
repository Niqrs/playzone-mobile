package com.niqr.playzone_mobile.android

import GamesRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import di.Inject.instance
import navigation.setupThemeNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gamesRepository = instance<GamesRepository>()
//        var gameTitle by mutableStateOf("")
//
//        CoroutineScope(Dispatchers.IO).launch {
//                gameTitle = gamesRepository.searchGame("a").count().toString()
//        }
//        setContent {
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    GreetingView("Title:${gameTitle}")
//                }
//            }
//        }
        setupThemeNavigation()
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
//    MyApplicationTheme {
//        GreetingView("Hello, Android!")
//    }
}
