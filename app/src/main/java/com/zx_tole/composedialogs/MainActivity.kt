package com.zx_tole.composedialogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zx_tole.composedialogs.ui.theme.ComposeDialogsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDialogsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }

                    Button(
                        modifier = Modifier.background(color= Color.Yellow)
                            .size(width = 300.dp, height= 200.dp),
                        onClick = {
                            setShowDialog(true)
                        }
                    ) {
                        Text("Show Dialog")
                    }

                    DialogDemo(showDialog, setShowDialog)
                }
            }
        }
    }
}

@Composable
fun DialogDemo(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text("Title")
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Text("This is a text on the dialog")
            },
        )
    }
}