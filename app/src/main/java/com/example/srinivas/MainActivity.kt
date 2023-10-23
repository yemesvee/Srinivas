package com.example.srinivas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.srinivas.ui.theme.SrinivasTheme
import androidx.compose.material3.Tab
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SrinivasTheme {
                var count by remember {
                    mutableStateOf(0)
                }
                var buttonEnable by remember { mutableStateOf(true) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.LightGray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Tab(selected = true, onClick = { /*TODO*/ }) {
                        Column(
                            Modifier.padding(10.dp).height(50.dp).fillMaxWidth(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            val selected = false
                            Box(
                                Modifier.size(10.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .background(
                                        color = if (selected) MaterialTheme.colorScheme.primary
                                        else MaterialTheme.colorScheme.background
                                    )
                            )
                            Text(
                                text = " tab",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                        
                    }
                    Text(text = "$count")

                    Button(onClick = {
                        count++
                        buttonEnable = true
                    }) {
                        Text(text = "CLICK ME")
                    }

                    Button(onClick = {
                        count = 0
                        buttonEnable = false
                    }) {
                        Text(text = "Reset count", color = Color.White)
                    }

                    ButtonEnable(buttonEnable) {
                        count--
                    }

                }
            }
        }
    }
}

@Composable
fun ButtonEnable(buttonEnable: Boolean, callback: () -> Unit) {
    Button(onClick = {
        callback.invoke()
    }, enabled = buttonEnable) {
        Text(text = "Enable")
    }
}