package com.hardi.stateinjetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

//remember -> remember the value of the variable across recompositions /persists the variable's value across recomposition
//rememberSavable -> remember the value of the variable at config changes
//Viewmodel + Livedata/ flow -> Hoist the state for the re-usability of the composable

@Composable
fun StateTestScreen(viewModel: StateViewmodel) {
    val name by viewModel.name.observeAsState("")
    val surname by viewModel.surname.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText("$name $surname")
        MyNameEdiText(name, onNameChange = {
            viewModel.changeName(it)
        })
        MySurNameEdiText(surname, onSurNameChange = {
            viewModel.changeSurName(it)
        })
    }
}

@Composable
fun MyText(name: String) {
    Text(text = "Hello $name", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold)
}

@Composable
fun MyNameEdiText(name: String, onNameChange: (String) -> Unit) {

    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = { Text(text = "Enter Your Name") }
    )
}

@Composable
fun MySurNameEdiText(surname: String, onSurNameChange: (String) -> Unit) {

    OutlinedTextField(
        value = surname,
        onValueChange = {
            onSurNameChange(it)
        },
        label = { Text(text = "Enter Your Surname") }
    )
}