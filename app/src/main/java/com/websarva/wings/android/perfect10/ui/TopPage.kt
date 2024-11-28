package com.websarva.wings.android.perfect10.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TopPage(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(text = "top")
    }
}

@Preview
@Composable
fun TopPagePreview(){
    TopPage(rememberNavController())
}
