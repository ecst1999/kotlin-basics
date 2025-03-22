package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyCardsMain(modifier: Modifier) {
    Column(modifier) {
        MyCard()
        MyDivider()
        MybadgeBox()
        MyDivider()
        MyDropDownMenu()
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(12.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.Red,
            contentColor = Color.Magenta
        ),
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Ejemplo 1")
            Text("Ejemplo 2")
            Text("Ejemplo 3")
        }
    }
}


@Composable
fun MybadgeBox() {
    BadgedBox(
        badge = {
            Badge(
                containerColor = Color.Blue,
                contentColor = Color.Green
            ) { Text("100") }
        },
        modifier = Modifier
            .padding(16.dp),
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Estrellita")
    }
}

@Composable
fun MyDivider() {
    HorizontalDivider(
        Modifier.fillMaxWidth(),
        color = Color.Red
    )
}

@Composable
fun MyDropDownMenu() {

    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Frappes")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach{ dessert ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = dessert
                }, text = { Text(dessert) })
            }
        }
    }
}
