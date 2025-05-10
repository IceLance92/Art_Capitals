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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Art_CapitalsTheme {
                One()
                }
            }
        }
    }

@Composable
fun One() {
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result) {
        1 -> R.drawable.saratov
        2 -> R.drawable.kazan
        3 -> R.drawable.toliatti
        4 -> R.drawable.penza
        5 -> R.drawable.saratov
        else -> R.drawable.moskva
    }
    val titleText = when(result) {
        1 -> R.string.saratov_title
        2 -> R.string.kazan_title
        3 -> R.string.toliati_title
        4 -> R.string.penza_title
        5 -> R.string.saratov_title
        else -> R.string.moskva_title
    }
    val cityText = when(result) {
        1 -> R.string.saratov_city
        2 -> R.string.kazan_city
        3 -> R.string.toliati_city
        4 -> R.string.penza_city
        5 -> R.string.saratov_city
        else -> R.string.moskva_city
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
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier.size(350.dp).offset(x = (0).dp, y = (6).dp)
            )
            Spacer( modifier = Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.height(200.dp)
            ) {
                Text(
                    text = stringResource(titleText),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(cityText),
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
                    onClick = { if (result > 1){
                        result--
                    } else {
                        result = 4
                    } },
                    modifier = Modifier.offset(x = (10).dp, y = (110).dp)
                ) { Text(stringResource(R.string.button_up)) }
                Spacer( modifier = Modifier.width(100.dp))
                Button(
                    onClick = { if (result < 4){
                        result++
                    } else {
                        result = 1
                    } },
                    modifier = Modifier.offset(x = (-15).dp, y = (110).dp)
                ) { Text(stringResource(R.string.button_next)) }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Art_CapitalsTheme {
        One()
    }
}