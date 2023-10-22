package com.example.codelab_compose_quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab_compose_quadrant.ui.theme.Codelab_compose_quadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Codelab_compose_quadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DisplayComposable(title: String, description: String, backgroundColor: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(GetBackgroundColor(color = backgroundColor))
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun GetBackgroundColor(color: Int): Color {
    when (color) {
        (1) -> return colorResource(id = R.color.color1)
        (2) -> return colorResource(id = R.color.color2)
        (3) -> return colorResource(id = R.color.color3)
        (4) -> return colorResource(id = R.color.color4)
    }
    return colorResource(id = R.color.black)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Codelab_compose_quadrantTheme {
        Column (modifier = Modifier.fillMaxSize()) {
            Row(
                Modifier.weight(1F)
            ) {
                DisplayComposable(
                    title = stringResource(id = R.string.Text_composable),
                    description = stringResource(id = R.string.text_description),
                    backgroundColor = 1,
                    modifier = Modifier.weight(1f)
                )
                DisplayComposable(
                    title = stringResource(id = R.string.Image_composable),
                    description = stringResource(id = R.string.Image_description),
                    backgroundColor = 2,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                Modifier.weight(1F)
            ) {
                DisplayComposable(
                    title = stringResource(id = R.string.Column_composable),
                    description = stringResource(id = R.string.Column_description),
                    backgroundColor = 3,
                    modifier = Modifier.weight(1f)
                )
                DisplayComposable(
                    title = stringResource(id = R.string.Row_composable),
                    description = stringResource(id = R.string.Row_description),
                    backgroundColor = 4,
                    modifier = Modifier.weight(1f)
                )
            }

        }
    }
}