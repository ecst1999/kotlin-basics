package com.ecst1999.jetpackcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyText(modifier: Modifier) {

    Column(modifier = modifier) {
        Text("Pepe")
        Text("Pepe rojo", color = Color.Red)
        Text("Pepe", fontSize = 25.sp)
        Text("FontStyle", fontStyle = FontStyle.Italic)
        Text(
            "FontWeight",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text("LetterSpacing", letterSpacing = 20.sp)

        Text(
            "TextDecoration",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable { }
        )

        Text(
            "TextDecoration", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline, TextDecoration.LineThrough
                )
            )
        )
        Text(
            "TextDecoration 2 forma",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )

        Text(
            "Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align, Align ppppp",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTextPreview() {
    MyText(Modifier.padding(top = 40.dp))
}