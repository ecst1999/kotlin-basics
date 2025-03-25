package com.ecst1999.jetpackcomposeapp

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ecst1999.jetpackcomposeapp.components.MyRadioButtonList

@Composable
fun MyDialogs(modifier: Modifier) {

    var showDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var showCustomDialog2 by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(15.dp)) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Column {
                OutlinedButton(
                    onClick = { showDialog = true }
                ) {
                    Text("Mostrar diálogo")
                }

                OutlinedButton(
                    onClick = { showCustomDialog = true },
                ) {
                    Text("Mostrar Custom Dialog")
                }

                OutlinedButton(
                    onClick = { showCustomDialog2 = true }
                ) {
                    Text("Mostrar cuenta de google")
                }

                OutlinedButton(
                    onClick = { showConfirmDialog = true }
                ) {
                    Text("Mostrar Confirm Dialog")
                }
            }


            MyAlertDialog(show = showDialog,
                onDismiss = {
                    showDialog = false
                },
                onConfirm = {
                    Log.i("danika", "Click")
                }
            )

            MySimpleCustomDialog(
                show = showCustomDialog,
                onDissmiss = { showCustomDialog = false }
            )

            MyCustomDialog(
                show = showCustomDialog2,
                onDismiss = { showCustomDialog2 = false }
            )

            MyConfirmationDialog(
                show = showConfirmDialog,
                onDismiss = { showConfirmDialog = false }
            )

        }
    }
}


@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (show) {
        AlertDialog(
            title = {
                Text("Titulo")
            },
            text = {
                Text("Hola soy una descripción super bonita :D")
            },
            onDismissRequest = {
                onDismiss()
            },
            confirmButton = {
                TextButton(
                    onClick = { onConfirm() }
                ) {
                    Text("Confirm Button")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismiss() }
                ) {
                    Text("Dissmiss Button")
                }
            }
        )
    }

}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDissmiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDissmiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {

                Text("Esto es un ejemplo")
                Text("Esto es un ejemplo")
                Text("Esto es un ejemplo")
            }
        }
    }

}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {

    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Set backup account")
                AccountItem("ejemplo1@gmail.com", R.drawable.avatar)
                AccountItem("ejemplo1@gmail.com", R.drawable.avatar)
                AccountItem("Añadir nueva cuenta", R.drawable.plus)
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier,
        color = Color.Black
    )
}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    var status by remember { mutableStateOf("") }

    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(
                    "Phone ringtone",
                    modifier = Modifier.padding(24.dp)
                )
                HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
                MyRadioButtonList(status) { status = it }
                HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    OutlinedButton(
                        onClick = {}
                    ) {
                        Text("CANCEL")
                    }
                    OutlinedButton(
                        onClick = {}
                    ) {
                        Text("OK")
                    }
                }
            }
        }

    }
}