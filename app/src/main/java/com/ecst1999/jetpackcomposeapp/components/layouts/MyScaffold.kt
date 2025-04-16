package com.ecst1999.jetpackcomposeapp.components.layouts

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold() {

    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet { MyDrawer(){
                coroutineScope.launch {
                    drawerState.close()
                }
            } }
        },
        gesturesEnabled = false
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    onClick = {
                        coroutineScope.launch {
                            scaffoldState.showSnackbar("Has pulsado aquí $it")
                        }
                    },
                    onclickDrawer = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            snackbarHost = {
                SnackbarHost(scaffoldState)
            },
            bottomBar = { MyBotonNavigation() },
            floatingActionButton = { MyFab() },
            floatingActionButtonPosition = FabPosition.End,

            ) {

        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClick: (String) -> Unit, onclickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text("Mi primera tool bar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            scrolledContainerColor = Color.Gray
        ),
        navigationIcon = {
            IconButton(onClick = { onclickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onClick("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = { onClick("Peligro") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }
    )
}

@Composable
fun MyBotonNavigation() {
    var index by remember { mutableStateOf(0) }
    NavigationBar(containerColor = Color.Red, contentColor = Color.White) {

        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorite") },
            label = { Text("Favorite") }
        )

        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person") },
            label = { Text("Person") }
        )

    }
}

@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.Yellow,
        contentColor = Color.Black,
        shape = CircleShape
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun MyDrawer(onClickClose: () -> Unit ) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            "Primera opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
        Text(
            "Segunda opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
        Text(
            "Tercera opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
        Text(
            "Cuarta opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
        Text(
            "Quinta opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
        Text(
            "Sexta opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
        Text(
            "Septima opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onClickClose() }
        )
    }
}