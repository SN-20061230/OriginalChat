package com.example.originalchat

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi

import androidx.navigation.compose.rememberNavController
import com.example.chat_app.Navigation.NavigationFile
import com.example.originalchat.ui.theme.OriginalChatTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OriginalChatTheme {
                val navController = rememberNavController()
                NavigationFile(navController = navController)
            }
        }
    }
}

