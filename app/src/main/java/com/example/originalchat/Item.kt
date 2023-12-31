package com.example.originalchat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chat_app.Navigation.Screens

@Composable
fun Item(name: String, navController: NavController) {
    Row(
        Modifier

            .padding(15.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Screens.Chat.getFullRoute(name = name))
            }) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account Image",
            Modifier.size(40.dp),
            tint = Color.White,

        )
        Text(fontSize = 24.sp, text = name, color = Color.White,
            modifier = Modifier.padding(start = 15.dp)
            )
    }
}