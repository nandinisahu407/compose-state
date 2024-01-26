package com.example.compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose_1.ui.theme.Compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_1Theme {
                MyScreen()
            }
        }
    }
}

@Composable
fun MyScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var amt by remember {
            mutableStateOf("")
        }

        Text(
            text="Tip Calculator",
            fontSize = 15.sp
        )

        OutlinedTextField(
            value =amt ,
            onValueChange = {
                            if(it.isNumeric() || it.isBlank()){
                                amt=it
                            }
            },
            label={Text(text="Enter Bill Amount")}
        )

        val amount=amt.toDoubleOrNull()?:0.0;
        val tip= calculatetip(amount)

        Text(
            text="Tip to Pay:$"+tip,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )







    }

}

private fun String.isNumeric():Boolean{
    return this.toDoubleOrNull()!=null;
}

private fun calculatetip(amount:Double, tipPer:Double=15.0):Double{
    val tip=amount*tipPer/100;
    return tip;
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Compose_1Theme {
        MyScreen()
    }
}