package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("ecst") }
    var value by remember { mutableStateOf("") }

    Column(modifier) {
        MyTextField(user = user) {
            user = it
        }
        MySecondTextField(value) {
            value = it
        }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = user.isEmpty())
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = { onValueChange(it) }, placeholder = {
        Box(Modifier.size(40.dp).background(Color.Red))
    }, label = {
        Text("Introduce tu email")
    })
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyTextFieldPreview() {
    MyTextFieldParent(Modifier.padding(top = 30.dp))
}