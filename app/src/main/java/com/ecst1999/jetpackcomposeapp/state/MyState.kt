package com.ecst1999.jetpackcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun MyState(modifier: Modifier){

    //var number = remember { mutableStateOf(0) }
    //var number by rememberSaveable { mutableIntStateOf(0) }

    var number by rememberSaveable { mutableIntStateOf(0) }

    Column {
        StateExample1(modifier, number) { number += 1 } //lambda function
        StateExample2(modifier, number, onClick = { number += 1 })
    }

}

@Composable
fun StateExample1(modifier: Modifier, number: Int, onClick: () -> Unit ){

    Text("Pulsame: $number", modifier.clickable { onClick() })
}

@Composable
fun StateExample2(modifier: Modifier, number: Int, onClick: () -> Unit){

    Text("Pulsame: $number", modifier.clickable { onClick() })
}