package com.example.chat_app.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chat_app.Database.Data
import com.example.originalchat.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        delay(1250)
        if (Data.getSavedUser(context) == "") navController.navigate("SignIn")
        else navController.navigate("Home")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
          ,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.logo2),
            contentDescription = "Splash",
        )
    }
}