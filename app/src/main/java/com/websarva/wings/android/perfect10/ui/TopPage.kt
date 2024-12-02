package com.websarva.wings.android.perfect10.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TopPage(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "top")

        Button(
            onClick = {navController.navigate("gamepage")},
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "はじめる")
        }
    }
}

@Preview
@Composable
fun TopPagePreview(){
    TopPage(rememberNavController())
}
