package com.ecst1999.jetpackcomposeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialogs(modifier: Modifier) {
    Column(modifier = modifier.padding(15.dp)) {
        MyAlertDialog()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAlertDialog() {

    BasicAlertDialog(
        onDismissRequest = {},
        content = { Text("Titulo") },
    )
}