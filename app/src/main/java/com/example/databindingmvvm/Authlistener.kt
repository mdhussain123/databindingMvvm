package com.example.databindingmvvm

import androidx.lifecycle.LiveData

interface Authlistener {
    fun onstarted()
    fun onsucess(loginresponse: LiveData<String>)
    fun onfailure(msg :String)
}