package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ecst1999.jetpackcomposeapp.CheckInfo

@Composable
fun MyControl(modifier: Modifier) {

    val myOptions = getOptions(listOf("Aris", "Ejemplo", "Pikachu"))

    Column(modifier.padding(top = 30.dp)) {
        MySwitch()
        MyCheckBox()
        MyCheckBoxWithText()
        MyCheckBoxWithText()
        myOptions.forEach{
            MyCheckBoxWithTextCompleted(it)
        }
    }
}

@Composable
fun getOptions(titles:List<String>):List<CheckInfo>{

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


