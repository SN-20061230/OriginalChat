package com.example.chat_app.Screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chat_app.Database.UserData
import com.example.originalchat.Database.UserClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var fullname by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(50, 165, 234)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Sign Up",
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.White,
                textColor = Color.White,
                placeholderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = "Your Username", color = Color.White) },
            placeholder = { Text(text = "Username", color = Color.White) },
            shape = RoundedCornerShape(12.dp)

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.White,
                textColor = Color.White,
                placeholderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            value = fullname,
            onValueChange = {
                fullname = it
            },
            label = { Text(text = "Your Full Name", color = Color.White) },
            placeholder = { Text(text = "Full Name", color = Color.White) },
            shape = RoundedCornerShape(12.dp)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.White,
                textColor = Color.White,
                placeholderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Your Password", color = Color.White) },
            placeholder = { Text(text = "Password", color = Color.White) },
            shape = RoundedCornerShape(12.dp)
        )
        Button(modifier = Modifier.padding(top = 27.dp), onClick = {
            if (" " in username.text) {
                Toast.makeText(context, "There is not any spaces left ", Toast.LENGTH_SHORT)
                    .show()
            } else {
                UserData.Usercheck(username.text) {
                    if (it) {
                        UserData.UserCreate(UserClass(fullname.text, username.text, password.text))
                        UserData.UserSave(context, username.text)
                        navController.navigate("Home")
                    } else {
                        Toast.makeText(
                            context, "Username already exists. Change username", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }) {
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                text = "Sign Up",
                fontSize = 19.sp
            )
        }
        Button(colors = ButtonDefaults.buttonColors(containerColor = Color(14, 22, 33)), onClick = {
            navController.navigate("SignIn")
        }) {
            Text(text = "Already have an account", fontSize = 17.sp)
        }
    }
}