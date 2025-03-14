package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ecst1999.jetpackcomposeapp.R

@Composable
fun MyImage(modifier: Modifier) {

    Column {
        Image(
            modifier = Modifier.padding(top = 45.dp, bottom = 10.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejemplo",
            alpha = 0.5f // opacidad
        )

        Image(
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejemplo",
            alpha = 0.5f // opacidad
        )
    }


}

@Preview(showSystemUi = true)
@Composable
fun MyImagePreview() {
    MyImage(Modifier.padding(top = 30.dp))
}