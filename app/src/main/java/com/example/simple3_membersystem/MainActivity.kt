package com.example.simple3_membersystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simple3_membersystem.ui.theme.Simple3_MemberSystemTheme
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simple3_MemberSystemTheme {
                // A surface container using the 'background' color from the theme
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var memberName by remember {
        mutableStateOf("")
    }
    var memberSutdentNumber by remember {
        mutableStateOf("")
    }
    var expanded by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                value = memberName,
                onValueChange = { memberName = it },
                label = {
                    Text(text = "姓名")
                }
            )
            TextField(
                value = memberSutdentNumber,
                onValueChange = { memberSutdentNumber = it },
                label = {
                    Text(text = "學號")
                }
            )
            Spacer(modifier = modifier.padding(5.dp))
            //年月日
            Row(
                modifier=Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

            }
            Box(modifier = modifier){
                Text(text = "  ",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            expanded = true
                        },
                    color = MaterialTheme.colorScheme.onBackground
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    for (value in 40..113) {
                        DropdownMenuItem(text = {  Text(text = ""+value)}, onClick = { expanded = false  })
                    }

                }
            }

        }
        }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Simple3_MemberSystemTheme {
        Greeting()
    }
}