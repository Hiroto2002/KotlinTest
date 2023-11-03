package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.padding(8.dp), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }

// modifierは引数で渡してあげれば初期値を変更できる。なくても大丈夫
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var array by remember {
        mutableStateOf(emptyArray<String>())
    }
    var text by remember {
        mutableStateOf("")
    }
    array+="a"
    Column {
        Row{
            OutlinedTextField(value = text, label = { Text(text = "TODOを書いてください") }, onValueChange = {text = it})
            Button(modifier=Modifier.height(100.dp),content = { Text(text = "追加") }, onClick = {
                array += text
                text = ""
            })
        }
        for( data in array){
            Todo(data = data)
        }
    }
}

// Composable:jetpack composeを使う
@Composable
fun Todo(data:String){
    var isCheck by remember {
        mutableStateOf(false)
    }
    Row {
        Text(text = data)
        Checkbox(checked = isCheck, onCheckedChange = { isCheck = !isCheck })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Androi")
    }
}