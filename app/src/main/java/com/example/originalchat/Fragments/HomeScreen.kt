package com.example.chat_app.Screens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chat_app.Database.Data
import com.example.originalchat.Database.Item

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var users by remember { mutableStateOf<List<String>>(emptyList()) }
    val context = LocalContext.current
    Data.getUsers { list ->
        users = list
    }

    Scaffold(containerColor = Color(41, 38, 43), topBar = {
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(
                41, 38, 43
            )
        ), title = {
            IconButton(onClick = { navController.navigate("Settings") }) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Settings Icon",
                    tint = Color(108, 120, 131),
                )

            }
            Text(text = "Current: " + Data.getSavedUser(context), color = Color.White, modifier = Modifier.padding(start = 150.dp, top = 10.dp))

        })
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 17.dp)
                .padding(innerPadding),
        ) {
            items(users) { item ->
                Item(name = item, navController)
            }
        }



    }
}