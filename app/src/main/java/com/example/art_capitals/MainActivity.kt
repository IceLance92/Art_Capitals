@file:Suppress("UNREACHABLE_CODE")

package com.example.art_capitals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.art_capitals.ui.theme.Art_CapitalsTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Art_CapitalsTheme {
                ArtworkScreen()
                }
            }
        }
    }

@Composable
fun ArtworkScreen() {
    var currentArtworkIndex by remember { mutableStateOf(0) }

    val artworks = listOf(
        ArtworkData(R.drawable.saratov, R.string.saratov_title, R.string.saratov_city),
        ArtworkData(R.drawable.kazan, R.string.kazan_title, R.string.kazan_city),
        ArtworkData(R.drawable.toliatti, R.string.toliati_title, R.string.toliati_city),
        ArtworkData(R.drawable.penza, R.string.penza_title, R.string.penza_city)
    )

    val currentArtwork = artworks[currentArtworkIndex]

    fun showPreviousArtwork() {
        currentArtworkIndex = (currentArtworkIndex - 1 + artworks.size) % artworks.size
    }

    fun showNextArtwork() {
        currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
    }

    Surface(
        modifier = Modifier.padding(10.dp)
    ) {
            Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(currentArtwork.imageResId),
                contentDescription = null,
                modifier = Modifier.size(350.dp).offset(x = (0).dp, y = (6).dp).clip(
                    RoundedCornerShape(80.dp))
            )
            Spacer( modifier = Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.height(200.dp)
            ) {
                Text(
                    text = stringResource(currentArtwork.titleResId),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(currentArtwork.cityResId),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.offset(x = (10).dp, y = (10).dp)
                )
            }
            Spacer( modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Button(
                    onClick = { showPreviousArtwork() },
                    modifier = Modifier.offset(x = (10).dp, y = (110).dp)
                ) { Text(stringResource(R.string.button_up)) }
                Spacer( modifier = Modifier.width(100.dp))
                Button(
                    onClick = { showNextArtwork() },
                    modifier = Modifier.offset(x = (-15).dp, y = (110).dp)
                ) { Text(stringResource(R.string.button_next)) }
            }
        }
    }
}

data class ArtworkData(
    val imageResId: Int,
    val titleResId: Int,
    val cityResId: Int
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Art_CapitalsTheme {
        ArtworkScreen()
    }
}