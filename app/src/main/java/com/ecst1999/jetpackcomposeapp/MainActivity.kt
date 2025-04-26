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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ecst1999.jetpackcomposeapp.login.Greeting
import com.ecst1999.jetpackcomposeapp.model.Routes
import com.ecst1999.jetpackcomposeapp.navigation.Screen1
import com.ecst1999.jetpackcomposeapp.navigation.Screen2
import com.ecst1999.jetpackcomposeapp.navigation.Screen3
import com.ecst1999.jetpackcomposeapp.navigation.Screen4
import com.ecst1999.jetpackcomposeapp.navigation.Screen5
import com.ecst1999.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeAppTheme {
//                enableEdgeToEdge()
                Surface(modifier = Modifier.fillMaxSize()) {

                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(Routes.Pantalla3.route) { Screen3(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("name") { defaultValue = "Pepe" })
                        ) { backStackEntry ->
                            Screen5(
                                navigationController,
                                backStackEntry.arguments?.getString("name")

                            )
                        }
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