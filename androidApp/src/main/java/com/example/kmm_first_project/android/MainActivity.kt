package com.example.kmm_first_project.android

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices.PIXEL
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmm_first_project.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                ScreenView(Greeting().greet())
            }
        }
    }
}

@Composable
fun ScreenView(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            GreetingView(text)
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineMedium
    )
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
        ScreenView("Hello, Android!")
    }
}
