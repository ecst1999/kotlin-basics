package com.ecst1999.jetpackcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyProgressAdvance() {

    var progreso by rememberSaveable { mutableStateOf(0.0f) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            progress = { progreso },
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            trackColor = Color.Blue
        )
        Row(Modifier.fillMaxSize()) {

            Button(onClick = {
                progreso += 0.1f
            }) {
                Text("Incrementar")
            }

            Button(onClick = {
                progreso -= 0.1f
            }) {
                Text("Reducir")
            }
        }
    }

}

@Composable
fun MyProgress(modifier: Modifier) {

    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier
            .padding(26.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier
                    .padding(top = 16.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }

        Button(
            onClick = {
                if (!showLoading) showLoading = true
                else if (showLoading) showLoading = false
            }
        ) {
            Text("Cargar perfil")
        }

        MyProgressAdvance()

    }
}

@Preview(showSystemUi = true)
@Composable
fun MyProgressPreview() {
    MyProgress(Modifier.padding(top = 35.dp))
}