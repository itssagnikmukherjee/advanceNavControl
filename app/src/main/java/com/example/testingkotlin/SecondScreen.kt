package com.example.testingkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SecondScreen(name:String,age:String, navToFirstScreen:()->Unit){
    Column(modifier= Modifier
        .padding()
        .fillMaxSize().background(Color(0xFF3498db)), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = "Hello! $name", fontSize = 44.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(text = "You are $age now \uD83D\uDE0D", fontSize = 44.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {navToFirstScreen()}) {
            Text(text = "Prev Screen")
        }
    }
}