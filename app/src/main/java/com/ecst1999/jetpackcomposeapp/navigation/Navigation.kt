package com.ecst1999.jetpackcomposeapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@Composable
fun Screen1(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text("Pantalla 1", Modifier
            .align(Alignment.Center)
            .clickable {
                navigationController.navigate("pantalla2")
            })

    }
}


@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text("Pantalla 2", Modifier.align(Alignment.Center).clickable {
            navigationController.navigate("pantalla3")
        })

    }
}


@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text("Pantalla 3", Modifier.align(Alignment.Center))

    }
}
