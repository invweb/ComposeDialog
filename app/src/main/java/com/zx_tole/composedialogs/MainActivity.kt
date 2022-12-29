package com.zx_tole.composedialogs

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
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
                    color = MaterialTheme.colors.background
                ) {
                    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }

                    Button(
                        modifier = Modifier.background(color= Color.Yellow)
                            .size(width = 250.dp, height= 50.dp),
                        onClick = {
                            setShowDialog(true)
                        }
                    ) {
                        Text(getString(R.string.show_dialog))
                    }

                    DialogDemo(showDialog, setShowDialog)
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
                    Text(getString(R.string.alert_dialog_title))
                },
                confirmButton = {
                    Button(
                        onClick = {
                            // Change the state to close the dialog
                            setShowDialog(false)

                            Toast.makeText(
                                this,
                                getString(R.string.dialogConfirmButtonClicked),
                                Toast.LENGTH_LONG
                            ).show()
                        },
                    ) {
                        Text(getString(R.string.confirm))
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            // Change the state to close the dialog
                            setShowDialog(false)

                            Toast.makeText(
                                this,
                                getString(R.string.dialogDismissButtonClicked),
                                Toast.LENGTH_LONG
                            ).show()
                        },
                    ) {
                        Text(getString(R.string.dismiss))
                    }
                },
                text = {
                    Text(getString(R.string.alert_dialog_text))
                },
            )
        }
    }
}