package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyIcon(modifier: Modifier){

    Column (modifier){
        Icon(
            imageVector = Icons.Rounded.Verified,
            contentDescription = "Icono",
            tint = Color.Red
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun MyIconPreview(){
    MyIcon(Modifier.padding(top = 35.dp))
}