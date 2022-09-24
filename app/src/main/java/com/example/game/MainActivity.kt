package com.example.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.game.ui.theme.GameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen()
                }
            }
        }
    }
}

fun cal(user:Int,android:Int):Int{
    if(user == 1 && android == 1){
        return 3//tie
    }else if(user == 1 && android == 2){
        return 2 //android
    }else if(user == 1 && android == 3){
        return 1 //user
    }else if(user == 2 && android == 1){
        return 1//user
    }else if(user == 2 && android == 2){
        return 3 //tie
    }else if(user == 2 && android == 3){
        return 3 //android
    }else if(user == 3 && android == 1){
        return 2 //android
    } else if(user == 3 && android == 2){
        return 1 //user
    }else if(user == 3 && android == 3){
        return 3 //tie
    }else{
        return 0
    }
}

@Composable
fun Screen() {
    var user by remember {
        mutableStateOf(0)
    }
    var Android by remember {
        mutableStateOf(0)
    }
    var chuser by remember {
        mutableStateOf("")
    }
    var anuser by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Column {
            Image(painter = painterResource(id = R.drawable.banner), contentDescription = "banner" )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Score", fontSize = 30.sp)
            Text(text = "$user/$Android", fontSize = 50.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "you chose", fontSize = 16.sp)
                Text(text = "$chuser", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Android Chose", fontSize = 16.sp)
                Text(text = "$anuser", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                var android = (1..3).random()
                 when(cal(user=1,android)){
                    1 -> user++
                    2 -> Android++
                     3-> null
                     else -> null
                }
                chuser = "Rock"
                anuser = when(android){
                    1 -> "Rock"
                    2 -> "Paper"
                    3 -> "Scissors"
                    else -> ""
                }
            }, modifier = Modifier.padding(20.dp, 30.dp), shape = RoundedCornerShape(20)) {
                Text(text = "Rock")
            }
            Button(onClick = {
                var android = (1..3).random()
                when(cal(user=1,android)){
                1 -> user++
                2 -> Android++
                    3-> null
                    else -> null
            }
                chuser = "Paper"
                anuser = when(android){
                    1 -> "Rock"
                    2 -> "Paper"
                    3 -> "Scissors"
                    else -> ""
                }}, modifier = Modifier.padding(20.dp, 30.dp), shape = RoundedCornerShape(20)) {
                Text(text = "Paper")
            }
            Button(onClick = {
                var android = (1..3).random()
                when(cal(user=1,android)){
                1 -> user++
                2 -> Android++
                    3-> null
                    else -> null
            }
                chuser = "Scissors"
                anuser = when(android){
                    1 -> "Rock"
                    2 -> "Paper"
                    3 -> "Scissors"
                    else -> ""
                }}, modifier = Modifier.padding(20.dp, 30.dp), shape = RoundedCornerShape(20)) {
                Text(text = "Scissor")
            }
        }
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "#JetpackCompose", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameTheme {
        Screen()
    }
}