package com.example.kmm_first_project.android

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmm_first_project.Greeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                ScreenView()
            }
        }
    }
}

@Composable
fun ScreenView(
    helloListInitialValue: String = ""
) {
    val greeting = remember { Greeting() }
    var helloList by remember { mutableStateOf(helloListInitialValue) }

    LaunchedEffect(Unit) {
        runCatching {
            withContext(Dispatchers.IO) {
                greeting.getHelloList()
            }
        }.onSuccess { s ->
            helloList = s
        }.onFailure { t ->
            helloList = "Error: ${t.localizedMessage}"
        }
    }

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            GreetingView(greeting.greet())
            MoviesView(helloList)
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun MoviesView(movies: String) {
    Column {
        Text(
            text = movies,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(
    name = "Light Mode",
    group = "FullScreen",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = PIXEL
)
@Preview(
    name = "Dark Mode",
    group = "FullScreen",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = PIXEL
)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ScreenView("One, Two, Three")
    }
}
