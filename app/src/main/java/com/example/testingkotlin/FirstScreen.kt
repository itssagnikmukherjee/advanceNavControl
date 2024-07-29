package com.example.testingkotlin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FirstScreen(navToSecondScreen:(String,String)->Unit){
    val context = LocalContext.current
    var txt:String by remember { mutableStateOf("") }
    var age:String by remember { mutableStateOf("") }
    Column(modifier= Modifier
        .padding()
        .fillMaxSize()
        .background(Color(0xFFf1c40f)), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = "Home", fontSize = 44.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = txt, onValueChange = {txt = it}, placeholder = { Text(text = "Enter your name ")})
        OutlinedTextField(value = age, onValueChange = {age = it}, placeholder = { Text(text = "Enter your age ")})
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {

            if(age=="" || txt==""){
                Toast.makeText(context,"Both values are required to continue",Toast.LENGTH_SHORT).show()
            }
            else{
                navToSecondScreen(txt,age)
            }
        }) {
            Text(text = "Next Screen")
        }
    }
}

