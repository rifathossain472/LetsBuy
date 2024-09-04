package com.esports.letsbuy.Views.register

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(
    val name: String,
    val email: String,
    val password: String,
    val userType: String,
    val userId: String
)
