package com.ecst1999.jetpackcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout(modifier: Modifier){

    Column(modifier = modifier) {
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Red)){}
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Blue)){
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(125.dp)
                        .background(Color.Gray)
                ) {  }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(180.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Hola")
                }
            }
        }
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Yellow)){}
    }

}