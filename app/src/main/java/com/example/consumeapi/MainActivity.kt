package com.example.consumeapi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.consumeapi.ui.theme.ConsumeApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsumeApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   teste()
                }
            }
        }
    }
}

@Composable
fun teste(){

    var characterId by remember {
        mutableStateOf("")
    }

    var teste by remember {
        mutableStateOf(true)
    }

    

    Column(modifier = Modifier.fillMaxSize()) {

        OutlinedTextField(value = characterId, onValueChange = {
            characterId = it
        })
        
        Button(onClick = {

            teste = false

        }) {
            Text(text = "clique em mim")
        }




        if (!teste){



            val context = LocalContext.current

            Toast.makeText(context, "$characterId", Toast.LENGTH_SHORT).show()
            TodoView(characterId = characterId.toInt())
        }
    }
}
