package com.example.chat_app.Screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chat_app.Database.UserData
import com.example.originalchat.Database.MessageClass
import com.example.originalchat.Database.MessageData
import com.example.originalchat.MessageItem

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(name: String, navController: NavController) {
    var msg by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    var messages by remember { mutableStateOf(emptyList<MessageClass>()) }
    MessageData.MessagesGet(name, UserData.getUserSaved(context)) { list ->
        messages = list
    }
    Scaffold(containerColor = Color.White, topBar = {
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(
                40, 143, 238
            )
        ), title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigate("Home") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = Color.White,
                    )
                }
                Text(text = name, color = Color.White)
            }
        })
    }, bottomBar = {
        BottomAppBar(containerColor = Color(40, 143, 238)) {
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Blue,
                    unfocusedBorderColor = White,
                    textColor = Color.White,
                    placeholderColor = Color.White,
                    focusedLabelColor = White,
                    unfocusedLabelColor = White
                    ),
                value = msg,
                onValueChange = {
                    msg = it
                },
                modifier = Modifier.padding(start = 15.dp),
                label = { Text(text = "Message") },
                placeholder = { Text(text = "Message") },

                shape = RoundedCornerShape(12.dp),


            )
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    MessageData.MessagesSend(UserData.getUserSaved(context), name, msg.text)
                    MessageData.MessagesGet(name, UserData.getUserSaved(context)) { list ->
                        messages = list
                    }
                    msg = TextFieldValue()
                }) {
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Default.Send,
                        contentDescription = "Send Icon",
                        tint = Color.Blue,

                    )
                }
            }
        }
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            items(messages) { item ->
                item.msg?.let { it1 ->
                    item.date?.let { it2 ->
                        MessageItem(
                            msg = it1,
                            time = it2,
                            position = item.from == UserData.getUserSaved(context)
                        )
                    }
                }
            }
        }
    }
}