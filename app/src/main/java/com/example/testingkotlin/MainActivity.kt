package com.example.testingkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testingkotlin.ui.theme.TestingKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainPreview()
                }
            }
        }
    }
}

@Composable
fun MainPreview(){
    // create variable which will remember the state
    val myNavController = rememberNavController()

    // create a navhost which will contain all the composable which we want to navigate
    NavHost(navController = myNavController, startDestination = "firstscreen") {
        composable("firstscreen"){
            FirstScreen {name, age->
                myNavController.navigate("secondscreen/$name/$age")
            }
        }
        composable("secondscreen/{name}/{age}"){
            val name = it.arguments?.getString("name")?: "no name"
            val age = it.arguments?.getString("age")?: "no age"
            SecondScreen(name,age){
                myNavController.popBackStack()
            }
        }
    }
}

