package com.ecst1999.jetpackcomposeapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ecst1999.jetpackcomposeapp.model.Routes


@Composable
fun Screen1(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .padding(top = 35.dp)
    ) {
        MyButton(Modifier.align(Alignment.CenterHorizontally))
        MyFilledTonalButton(Modifier.align(Alignment.CenterHorizontally))
        MyElevatedTonalButton(Modifier.align(Alignment.CenterHorizontally))

        Text(
            "Pantalla 1", Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navigationController.navigate(Routes.Pantalla2.route)
                }, color = Color.White
        )
        MyFloatingActionButton()
    }

}


@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            "Pantalla 2", Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Pantalla3.route)
                }, color = Color.White
        )

    }
}


@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            "Pantalla 3", Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Pantalla4.createRoute(29))
                }, color = Color.White
        )
    }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            "Tienes la edad de: $age años",
            Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Pantalla5.createRoute("Steve")) },
            color = Color.White
        )

    }
}

@Composable
fun Screen5(navigationController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text("Me llamo $name", Modifier.align(Alignment.Center), color = Color.White)

    }
}


// MATERIAL 3 Components

@Composable
fun MyButton(modifier: Modifier) {
    Button(
        onClick = {},
        modifier = modifier,
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Blue
        )
    ) {
        Text("Holiwi")
    }
}

@Composable
fun MyFilledTonalButton(modifier: Modifier) {
    FilledTonalButton(onClick = {}, modifier = modifier) {
        Text("Holiwi")
    }
}

@Composable
fun MyElevatedTonalButton(modifier: Modifier) {
    ElevatedButton(onClick = {}, modifier = modifier) {
        Text("Holiwi")
    }
}

@Composable
fun MyFloatingActionButton() {

    FloatingActionButton(onClick = {}, containerColor = Color.Red) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite FAB")
    }

    Spacer(Modifier.height(8.dp))

    SmallFloatingActionButton(onClick = {}, containerColor = Color.Red) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite FAB")
    }

    Spacer(Modifier.height(8.dp))

    LargeFloatingActionButton(onClick = {}, containerColor = Color.Red) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite FAB")
    }

    Spacer(Modifier.height(8.dp))

    ExtendedFloatingActionButton(onClick = { print("Hello") }) {
        Text(text ="Extended FAB")
        Icon(Icons.Filled.Favorite, "Floating action button.")
    }
}