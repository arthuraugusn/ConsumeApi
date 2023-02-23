package com.example.consumeapi
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun TodoView(characterId: Int){
    
    val characterState = remember {
        mutableStateOf<Todo?>(null)
    }

    LaunchedEffect(characterId){
        val charater  = APIService.getApi().getCharacter(characterId)

        characterState.value =charater

    }

    Column {
        characterState.value?.let { Text(text = it.name) }
    }

}