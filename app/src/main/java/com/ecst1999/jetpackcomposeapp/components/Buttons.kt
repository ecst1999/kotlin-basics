package com.ecst1999.jetpackcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {

    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("ecst", "Botón pulsado") },
            enabled = false,
            shape = RoundedCornerShape(20),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.Gray,
                disabledContainerColor = Color.Yellow,
                disabledContentColor = Color.Green
            )
        ) {
            Text("Pulsame")
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Blue
            )
        ) {
            Text("Outlined")
        }

        TextButton(
            onClick = {}
        ) {
            Text("TextButton")
        }

        FilledTonalButton(onClick = {}) { }
        Button(onClick = {}) { }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyButtonsPreview() {
    MyButtons(Modifier.padding(top = 20.dp))
}