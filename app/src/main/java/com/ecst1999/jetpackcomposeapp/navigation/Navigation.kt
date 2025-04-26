package com.ecst1999.jetpackcomposeapp.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.SensorDoor
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ecst1999.jetpackcomposeapp.model.Routes
import kotlin.random.Random.Default.nextInt


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

        TextButton(
            onClick = {
                navigationController.navigate(Routes.Pantalla2.route)
            },
            content = { Text("Pantalla 1") },
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )
        MyFloatingActionButton()
    }

}


@Composable
fun Screen2(navigationController: NavHostController) {

    var firstColor by rememberSaveable { mutableStateOf(false) }
    val realColor = if (firstColor) Color.Magenta else Color.Yellow
    var showBox by rememberSaveable { mutableStateOf(true) }

    var secondColor by rememberSaveable { mutableStateOf(false) }
    val realColor2 by animateColorAsState(
        if (secondColor) Color.Green else Color.Blue,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = !showBox }

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable {
                    firstColor = !firstColor
                }
        )

        Spacer(Modifier.size(200.dp))

        if (showBox) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColor2)
                    .clickable {
                        secondColor = !secondColor
                    }
            )
        }


        Text(
            "Pantalla 2", Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navigationController.navigate(Routes.Pantalla3.route)
                },
            color = Color.DarkGray,
            fontSize = 20.sp
        )

    }
}


@Composable
fun Screen3(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {

        Text(
            "Pantalla 3", Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navigationController.navigate(Routes.Pantalla4.createRoute(29))
                },
            color = Color.White,
            fontSize = 20.sp
        )

        SizeAnimation()
        VisibilityAnimation()
        CrossfadeExampleAnimated()
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
        Text(text = "Extended FAB")
        Icon(Icons.Filled.Favorite, "Floating action button.")
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = {
            if (!smallSize) {/*TODO*/
            }
        }
    )

    Box(modifier = Modifier
        .size(size)
        .background(Color.Red)
        .clickable {
            smallSize = !smallSize
        }
    )
}

@Composable
fun VisibilityAnimation() {

    var isVisible by rememberSaveable { mutableStateOf(true) }

    Column() {

        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text("Mostrar / Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {

            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Yellow)
            )
        }


    }

}

@Composable
fun CrossfadeExampleAnimated() {
    var myComponentType: ComponentType by rememberSaveable { mutableStateOf(ComponentType.Text) }

    Column(Modifier.fillMaxSize()) {

        Button(
            onClick = {
                myComponentType = getComponentTypeRandom()
            }
        ) {
            Text("Cambiar componente")
        }

        Crossfade(targetState = myComponentType)  {
            when(it){
                ComponentType.Image -> Icon(Icons.Default.SensorDoor, contentDescription = "Sensor door")
                ComponentType.Text -> Text("Soy un componente")
                ComponentType.Box -> Box(Modifier.size(150.dp).background(Color.Red))
                ComponentType.Error -> Text("ERRORRRRRRRRRRR")
            }
        }

    }


}

enum class ComponentType() {
    Image, Text, Box, Error
}

fun getComponentTypeRandom(): ComponentType{
    return when(nextInt(from = 0, until = 3)){
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}










