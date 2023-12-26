package com.example.originalchat.Database


data class UserClass(
    val fullname: String?,
    var username: String?,
    var password: String?,
) {
    constructor() : this(null, null, null)
}