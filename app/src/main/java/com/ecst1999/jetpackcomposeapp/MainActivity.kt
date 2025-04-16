package com.ecst1999.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecst1999.jetpackcomposeapp.login.Greeting
import com.ecst1999.jetpackcomposeapp.navigation.Screen1
import com.ecst1999.jetpackcomposeapp.navigation.Screen2
import com.ecst1999.jetpackcomposeapp.navigation.Screen3
import com.ecst1999.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeAppTheme {
                enableEdgeToEdge()
                Surface (modifier = Modifier.fillMaxSize()) {

                    val navigationController = rememberNavController()

                    NavHost(navController = navigationController, startDestination = "pantalla1"){
                        composable("pantalla1"){ Screen1(navigationController) }
                        composable("pantalla2"){ Screen2(navigationController) }
                        composable("pantalla3"){ Screen3(navigationController) }
                    }

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeAppTheme {
        Greeting("Android")
    }
}