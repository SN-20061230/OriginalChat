package com.example.originalchat.Database

data class MessageClass(
    val from: String?,
    val to: String?,
    val msg: String?,
    val date: String?,
) {
    constructor() : this(null, null, null, null)
}
