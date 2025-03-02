@file:Suppress("UNREACHABLE_CODE")

package com.example.art_capitals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_capitals.ui.theme.Art_CapitalsTheme

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
    Surface(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.saratov),
                contentDescription = null,
                modifier = Modifier
            )
            Spacer( modifier = Modifier.height(40.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(R.string.saratov_title),
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = stringResource(R.string.saratov_city),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer( modifier = Modifier.height(150.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {  }
                ) { Text(stringResource(R.string.button_up)) }
                Spacer( modifier = Modifier.width(100.dp))
                Button(
                    onClick = {  }
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