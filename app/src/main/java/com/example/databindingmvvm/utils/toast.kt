package com.example.databindingmvvm.utils

import android.content.Context
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(msg : String){
Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}
fun ProgressBar.show(){
    ProgressBar.VISIBLE
}
fun ProgressBar.hide(){
    ProgressBar.GONE
}