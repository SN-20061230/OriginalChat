package com.example.originalchat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageItem(msg: String, time: String, position: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        if (position) {
            Spacer(modifier = Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.End) {
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(43, 72, 180), RoundedCornerShape(33))
                        .padding(horizontal = 12.dp, vertical = 7.dp),
                    shape = RoundedCornerShape(22.dp),
                ) {
                    Text(
                        modifier = Modifier.background(Color(43, 72, 180)),
                        fontSize = 25.sp,
                        text = msg,
                        color = Color.White,
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    fontSize = 17.sp,
                    text = time,
                    color = Color(40, 143, 238)
                )
            }
        } else {
            Column(horizontalAlignment = Alignment.Start) {
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(40, 143, 238), RoundedCornerShape(33))
                        .padding(horizontal = 12.dp, vertical = 7.dp),

                            shape = RoundedCornerShape(22.dp),
                        ) {
                    Text(
                        modifier = Modifier.background(Color(40, 143, 238)),
                        fontSize = 25.sp,
                        text = msg,
                        color = Color.White,
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    fontSize = 17.sp,
                    text = time,
                    color = Color(40, 143, 238)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}