package com.example.originalchat.Database


data class User(
    val fullname: String?,
    var username: String?,
    var password: String?,
) {
    constructor() : this(null, null, null)
}