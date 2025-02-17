package com.ecst1999.jetpackcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun MyRow(modifier: Modifier){
    Row(modifier = modifier.fillMaxSize().horizontalScroll(rememberScrollState())){

        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Blue))
        Text("Hola 3", modifier = Modifier.background(Color.Cyan))
        Text("Hola 4", modifier = Modifier.background(Color.Magenta))


    }
}