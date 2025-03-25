package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier) {
    Column(modifier = modifier.padding(25.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        MySliderBasic()
        MyAdvancedSlider()
        MyRangeSlider()
    }
}


@Composable
fun MySliderBasic() {

    var sliderPosition by remember { mutableStateOf(0f) }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it }
    )
    Text("$sliderPosition")

}

@Composable
fun MyAdvancedSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var completeValue by remember { mutableStateOf("") }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        onValueChangeFinished = {
            completeValue = sliderPosition.toString()
        }, // Ejecución al soltar el slider
        modifier = Modifier.padding(top = 20.dp),
        valueRange = 0f..10f,
        steps = 9
    )
    Text(completeValue)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }
    RangeSlider(
        value = currentRange,
        onValueChange = { currentRange = it },
        valueRange = 0f..10f,
        steps = 9
    )
    Text("Valor inferior ${currentRange.start}")
    Text("Valor superior ${currentRange.endInclusive}")
}