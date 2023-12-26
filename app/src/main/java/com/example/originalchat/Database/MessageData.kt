package com.example.originalchat.Database

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Locale

class MessageData {
companion object{
    private val messages = FirebaseDatabase.getInstance().reference.child("messages")

    @RequiresApi(Build.VERSION_CODES.O)
    fun MessagesSend(from: String, to: String, msg: String) {
        val currentTimeMillis = System.currentTimeMillis()
        val formattedDateTime = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault()).format(currentTimeMillis)
        val data = MessageClass(from, to, msg, formattedDateTime)
        messages.push().setValue(data)
    }
    fun MessagesGet(chat: String, user: String, callback: (List<MessageClass>) -> Unit) {
        messages.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val messages = dataSnapshot.children.mapNotNull { it.getValue(MessageClass::class.java) }
                    .filter { (it.from == chat && it.to == user) || (it.from == user && it.to == chat) }

                callback(messages)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                callback(emptyList())
            }
        })
    }
}}