package com.ecst1999.jetpackcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyConstraintLayout2(modifier: Modifier){

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxCyan, boxBlack, boxGray, boxMagenta, boxGreen, boxYellow, boxGray2, boxRed, boxBlue) = createRefs()

        Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(boxYellow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxMagenta.top)
            end.linkTo(boxMagenta.end)
        })

        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack){
            start.linkTo(boxCyan.end)
            end.linkTo(boxGray.start)
            bottom.linkTo(boxCyan.bottom)
            top.linkTo(boxCyan.top)
        })

        Box(Modifier.size(175.dp).background(Color.DarkGray).constrainAs(boxGray){
            bottom.linkTo(boxGreen.top)
            start.linkTo(boxGreen.start)
        })

        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxYellow.top)
            end.linkTo(boxYellow.start)
        })

        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
        })

        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray2){
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })

        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })



    }
    //75dp, 175dp
}

@Preview(showBackground = true)
@Composable
fun MyConstraintLayout2Preview(){
    MyConstraintLayout2(modifier = Modifier.fillMaxSize())
}
