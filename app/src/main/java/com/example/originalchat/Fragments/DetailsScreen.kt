package com.example.chat_app.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chat_app.Database.UserData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(containerColor = Color.White, topBar = {
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(
                50, 165, 234
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
                Text(UserData.getUserSaved(context), color = Color.White)
            }
        })
    },
        bottomBar = {
            BottomAppBar(containerColor = Color(40, 143, 238), modifier = Modifier.height(70.dp)) {


//                Row(modifier = Modifier.fillMaxWidth().height(80.dp)){





                IconButton(modifier = Modifier.fillMaxSize(), onClick = { navController.navigate("Home") }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home Icon",
                        tint = Color(235, 231, 139),
                        modifier = Modifier.width(50.dp).height(50.dp)
                    )

                }

            }
        }
        ) { innerPadding ->
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var username by remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(innerPadding),
        ) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Change Password",

                color = Color(50, 165, 234)
            )


            OutlinedTextField(
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    textColor =Color(50, 165, 234)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text(text = "Your New Password", color = Color(50, 165, 234)) },
                placeholder = { Text(text = "Password", color = Color(50, 165, 234)) },
                shape = RoundedCornerShape(12.dp)


            )
            Button(modifier = Modifier.padding(top = 10.dp, start = 115.dp), onClick = {
                UserData.ChangePassword(UserData.getUserSaved(context), password.text)
                Toast.makeText(context, "Password changed successfully", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Change", fontSize = 20.sp)
            }
            Button(modifier = Modifier.padding(top = 5.dp,  start = 60.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),
                onClick = {
                    UserData.UserSave(context, "")
                    navController.navigate("SignIn")
                }) {
                Text(text = "Log out from system", fontSize = 20.sp)
            }

        }












    }
}