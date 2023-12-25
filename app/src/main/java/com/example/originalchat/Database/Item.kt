package com.example.originalchat.Database

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
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

            .padding(17.dp)
            .width(150.dp)
            .clickable {
                navController.navigate(route = Screens.Chat.getFullRoute(name = name))
            }) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Icon",
            Modifier.size(32.dp),
            tint = Color.White,
        )
        Text(fontSize = 24.sp, text = name, color = Color.White)
    }
    Divider(modifier = Modifier.height(5.dp), thickness = 2.dp, color = Color.Green)
}