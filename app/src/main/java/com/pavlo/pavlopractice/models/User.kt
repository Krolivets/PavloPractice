package com.pavlo.pavlopractice.models

import java.io.Serializable
// todo: add country
data class User(
    val firstName: String,
    val lastName: String,
    val age: String,
    val address: String,
) : Serializable
