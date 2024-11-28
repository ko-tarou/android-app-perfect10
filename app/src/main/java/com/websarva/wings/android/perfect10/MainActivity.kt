package com.websarva.wings.android.perfect10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.websarva.wings.android.perfect10.ui.GamePage
import com.websarva.wings.android.perfect10.ui.TopPage
import com.websarva.wings.android.perfect10.ui.theme.Perfect10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Perfect10Theme {
                val navController = rememberNavController()
                Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "toppage",
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable("toppage"){
                            TopPage(navController)
                        }
                        composable("gamepage"){
                            GamePage(navController)
                        }

                    }
                }
            }
        }
    }
}

