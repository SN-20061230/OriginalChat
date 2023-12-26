package com.example.chat_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.chat_app.Database.UserData
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        delay(6000)
        if (UserData.getUserSaved(context) == "") navController.navigate("SignIn")
        else navController.navigate("Home")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(40, 143, 238))
          ,
        contentAlignment = Alignment.Center,
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://lottie.host/c72752bc-861a-4e7f-81c0-f2df40124ea7/3kNbTr6en5.lottie"))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}