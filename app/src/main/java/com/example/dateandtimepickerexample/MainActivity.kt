package com.example.dateandtimepickerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dateandtimepickerexample.ui.theme.DateAndTimePickerExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateAndTimePickerExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DateTimePickerComponent()
                }
            }
        }
    }
}

@Composable
fun DateTimePickerComponent(modifier: Modifier = Modifier) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = "日付が選択されていません")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "日付選択")
        }
        Divider(modifier = Modifier.padding(vertical = 24.dp))
        Text(text = "時間が選択されていません")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "時間選択")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DateAndTimePickerExampleTheme {
        DateTimePickerComponent()
    }
}