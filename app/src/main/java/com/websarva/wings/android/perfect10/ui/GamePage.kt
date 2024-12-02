package com.websarva.wings.android.perfect10.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlin.concurrent.timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun GamePage(navController: NavController){

    var timerText:String by remember { mutableStateOf("ボタンを押してね") }
    var timeLeft:Float by remember { mutableStateOf(10f) }
    var timeIs:Boolean by remember { mutableStateOf(true) }
    var stopIs:Boolean by remember { mutableStateOf(false) }
    var daiIs:Boolean by remember { mutableStateOf(true) }

    if(timerText == "スタート！"){
        LaunchedEffect(Unit) {
            while (!(timeLeft == 10f) and !stopIs){
                delay(10)
                timeLeft = timeLeft-0.01f
            }
        }
    }

    if(timeLeft < 5f){
        timeIs = false
    }

    if(stopIs){
        AlertDialog(
            onDismissRequest = { daiIs = false},
            title = { Text(
                text = "記録",
                textAlign = TextAlign.Center,
            )},
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = String.format("%.2f 秒", timeLeft)
                    )
                }
            },

            confirmButton = {
                TextButton(onClick = {daiIs = false}) {
                    Text("閉じる")
                }
            },
        )
    }

    if(!daiIs){
        timeIs = true
        daiIs = true
        stopIs = false
        timerText = "ボタンを押してね"
        timeLeft = 10f
    }

    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(200.dp))

        Text(
            text = timerText,
            fontSize = 40.sp
        )

        Box {
            Column (
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ){
                Spacer(modifier = Modifier.height(50.dp))

                if(timeIs or stopIs){
                    Text(
                        fontSize = 40.sp,
                        text = String.format("%.2f",timeLeft),
                    )
                }
            }


            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ){
                Button(
                    onClick = {
                        if(!stopIs) {
                            if (timerText == "スタート！") {
                                stopIs = true
                            } else {
                                timerText = "スタート！"
                                timeLeft = timeLeft - 0.1f
                            }
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                ) {

                }
            }
        }
    }
}

@Preview
@Composable
fun GamePagePreview(){
    GamePage(rememberNavController())
}