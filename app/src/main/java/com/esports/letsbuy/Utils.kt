package com.esports.letsbuy

import android.widget.EditText

fun EditText.isEmpty(): Boolean{
    return if (this.text.toString().isEmpty()){
        this.error = "This field must be fill up"
        true
    }else{
        false
    }
}