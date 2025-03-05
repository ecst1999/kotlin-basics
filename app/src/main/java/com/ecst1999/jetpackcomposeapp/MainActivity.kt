package com.ecst1999.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ecst1999.jetpackcomposeapp.components.MyText
import com.ecst1999.jetpackcomposeapp.components.MyTextField
import com.ecst1999.jetpackcomposeapp.components.MyTextFieldParent
import com.ecst1999.jetpackcomposeapp.components.layouts.ConstraintAvanzado
import com.ecst1999.jetpackcomposeapp.components.layouts.ConstraintBarrier
import com.ecst1999.jetpackcomposeapp.components.layouts.ConstraintChain
import com.ecst1999.jetpackcomposeapp.components.layouts.EjercicioBox
import com.ecst1999.jetpackcomposeapp.components.layouts.MyBasicConstraintLayout
import com.ecst1999.jetpackcomposeapp.components.layouts.MyBox
import com.ecst1999.jetpackcomposeapp.components.layouts.MyColumn
import com.ecst1999.jetpackcomposeapp.components.layouts.MyComplexLayout
import com.ecst1999.jetpackcomposeapp.components.layouts.MyConstraintLayout2
import com.ecst1999.jetpackcomposeapp.components.layouts.MyRow
import com.ecst1999.jetpackcomposeapp.login.Greeting
import com.ecst1999.jetpackcomposeapp.state.MyState
import com.ecst1999.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyTextFieldParent(Modifier.padding(innerPadding))
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