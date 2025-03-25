package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.ecst1999.jetpackcomposeapp.CheckInfo

@Composable
fun MyControl(modifier: Modifier) {

    val myOptions = getOptions(listOf("Aris", "Ejemplo", "Pikachu"))

    var selected by rememberSaveable { mutableStateOf("ecst") }

    Column(modifier.padding(top = 30.dp)) {
        MyRadioButtonList(selected) { selected = it }
        MySwitch()
        MyCheckBox()
        MyCheckBoxWithText()
        MyCheckBoxWithText()
        MyTritStatusCheckBox()
        myOptions.forEach {
            MyCheckBoxWithTextCompleted(it)
        }
        MyRadioButton()

    }
}

@Composable
fun MyTritStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyRadioButton() {

    Row(Modifier.fillMaxSize()) {
        RadioButton(
            selected = false,
            enabled = false,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Blue
            )
        )
        Text("Ejemplo 1")
    }

}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {


    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "ecst",
                onClick = { onItemSelected("ecst") },
                colors = RadioButtonDefaults.colors(
                    Color.Black
                )
            )
            Text("ecst", color = Color.Black)
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "David",
                onClick = { onItemSelected("David") },
                colors = RadioButtonDefaults.colors(
                    Color.Black
                )
            )
            Text("David", color = Color.Black)
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "Karlita",
                onClick = { onItemSelected("Karlita") },
                colors = RadioButtonDefaults.colors(
                    Color.Black
                )
            )
            Text("Karlita", color = Color.Black)
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(6.dp)) {
            RadioButton(
                selected = name == "Daniela",
                onClick = { onItemSelected("Daniela") },
                colors = RadioButtonDefaults.colors(
                    Color.Black
                )
            )
            Text("Daniela", color = Color.Black)
        }
    }

}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {

    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }


}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta,
            uncheckedTrackColor = Color.Cyan,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.White,
            disabledUncheckedTrackColor = Color.Black
        )
    )

}

@Composable
fun MyCheckBox() {

    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )

}

@Composable
fun MyCheckBoxWithText() {

    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(top = 8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text("Ejemplo 1")
    }

}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {


    Row(Modifier.padding(top = 8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(checkInfo.title)
    }

}


