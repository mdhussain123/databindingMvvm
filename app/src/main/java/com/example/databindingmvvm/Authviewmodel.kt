package com.example.databindingmvvm

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.databindingmvvm.repository.UserRepository

class Authviewmodel : ViewModel() {
    var email :String?=null
    var password :String?=null
    var authlisterner :Authlistener?=null
    fun onclicklogin(view :View){
        authlisterner?.onstarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authlisterner?.onfailure("Invalid email or password")
            return
        }
        //success
        val loginresponse=UserRepository().userlogin(email!!,password!!)
        authlisterner?.onsucess(loginresponse)

    }
}