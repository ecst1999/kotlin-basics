package com.ecst1999.jetpackcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EjercicioBox(modifier: Modifier){

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ){
            Text("Ejemplo 1", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ){
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Ejemplo 2", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.width(20.dp))
                Box (
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ){
                    Text("Ejemplo 3", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ){
            Text("Ejemplo 4", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}