package com.example.dateandtimepickerexample

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePickerComponent(modifier: Modifier = Modifier) {

    //  テキスト変換用のフォーマット
    val dateFormatter = java.text.SimpleDateFormat("yyyy年 MM月 dd日", java.util.Locale.getDefault())

    //  DatePickerの状態保持用
    val datePickerState = rememberDatePickerState()
    //  TimePickerの状態保持用
    val timePickerState = rememberTimePickerState()

    //  日付選択UIの表示状態
    var showDatePicker by remember { mutableStateOf(false) }
    //  日時選択UIの表示状態
    var showTimePicker by remember { mutableStateOf(false) }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                    }
                ) {
                    Text(text = "確定")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                    }
                ) {
                    Text(text = "キャンセル")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { /*TODO*/ },
            confirmButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                    }
                ) {
                    Text(text = "確定")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                    }
                ) {
                    Text(text = "キャンセル")
                }
            }
        ) {
            TimePicker(state = timePickerState)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val selectedDate =  datePickerState.selectedDateMillis
        if(selectedDate == null) {
            Text(text = "日付を選択してください")
        }else{
            Text(text =  dateFormatter.format(java.util.Date(selectedDate)))
        }
        Button(onClick = { showDatePicker = true }) {
            Text(text = "日付選択")
        }
        Divider(modifier = Modifier.padding(vertical = 24.dp))
        Text(text = "時間が選択されていません")
        Button(onClick = { showTimePicker = true }) {
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